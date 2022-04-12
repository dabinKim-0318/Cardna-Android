package org.cardna.presentation.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.cardna.BuildConfig
import com.example.cardna.R
import com.example.cardna.databinding.ActivityLoginBinding
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.log.NidLog
import com.navercorp.nid.oauth.OAuthLoginCallback
import dagger.hilt.android.AndroidEntryPoint
import org.cardna.data.local.singleton.CardNaRepository
import org.cardna.presentation.MainActivity
import org.cardna.presentation.base.BaseViewUtil
import org.cardna.presentation.ui.login.viewmodel.LogInViewModel
import timber.log.Timber

@AndroidEntryPoint
class LoginActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivityLoginBinding>(R.layout.activity_login) {

    private val loginViewModel: LogInViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        setClickListener()
        loginSuccessObserve()

        Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.kakaoUserfirstName)
        Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.kakaoUserToken)
        Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.kakaoSocial)
        Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.kakaoUuId)

        Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.naverUserfirstName)
        Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.naverUserToken)
        Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.naverSocial)
        Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.naverUuId)
    }

    private fun setClickListener() {
        with(binding) {
            tvLoginPolicyUseOfTerm.setOnClickListener {

            }
            tvLoginPolicyPrivate.setOnClickListener {


            }
            btnLoginKakao.setOnClickListener {
                setKakaoLogin()
            }
            btnLoginNaver.setOnClickListener {
                setNaverLogin()
            }
        }
    }

    private fun setNaverLogin() {
        NidLog.init()
        NaverIdLoginSDK.initialize(
            this,
            BuildConfig.NAVER_API_CLIENT_ID,
            BuildConfig.NAVER_API_CLIENT_SECRET,
            BuildConfig.NAVER_API_APP_NAME
        )

        val oauthLoginCallback = object : OAuthLoginCallback {
            override fun onError(errorCode: Int, message: String) {
                onFailure(errorCode, message)
            }

            override fun onFailure(httpStatus: Int, message: String) {
                val errorCode = NaverIdLoginSDK.getLastErrorCode().code
                val errorDesc = NaverIdLoginSDK.getLastErrorDescription()
                Log.e("naver login error : ", "errorCode:$errorCode, errorDesc:$errorDesc")
            }

            override fun onSuccess() {
                val accessToken = NaverIdLoginSDK.getAccessToken() ?: return
                val refreshToken = NaverIdLoginSDK.getRefreshToken() ?: return

                //이름이 있었음->로그아웃하거나 토큰 만료됨: 그냥 로그인
                if (CardNaRepository.naverUserfirstName != "") {
                    loginViewModel.signInWithNaver(accessToken)
                }
                //이름없음->가입 또는 탈퇴한유저 재가입 : 회원가입
                else if (CardNaRepository.naverUserfirstName == "") {
                    loginViewModel.signUpWithNaver(accessToken)
                }

            }
        }
        //  NidOAuthLogin().logout()
        NaverIdLoginSDK.authenticate(this, oauthLoginCallback)
    }

    private fun setKakaoLogin() {
        //기존 가입했던적 유무 조사
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Timber.e(error, "카카오 로그인 실패")
            } else if (token != null) {
                UserApiClient.instance.me { user, error ->
                    val accessToken = token.accessToken
                    val refreshToken = token.refreshToken
                    Log.e("kakao login", token.accessToken)
                    Log.e("kakao login", token.refreshToken)

                    //이름이 있었음->로그아웃하거나 토큰 만료됨: 그냥 로그인
                    if (CardNaRepository.kakaoUserfirstName != "") {
                        loginViewModel.signInWithKakao(accessToken)
                    }
                    //이름없음->가입 또는 탈퇴한유저 재가입 : 회원가입
                    else if (CardNaRepository.kakaoUserfirstName == "") {
                        loginViewModel.signUpWithKakao(accessToken)
                    }
                }
            }
        }

        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this@LoginActivity)) {
            UserApiClient.instance.loginWithKakaoTalk(this@LoginActivity, callback = callback)

        } else {
            UserApiClient.instance.loginWithKakaoAccount(this@LoginActivity, callback = callback)
        }
    }


    private fun loginSuccessObserve() {
        loginViewModel.signUpWithKakaoSuccess.observe(this) {
            if (it) startActivity(Intent(this@LoginActivity, SetNameActivity::class.java))
        }
        loginViewModel.signInWithKakaoSuccess.observe(this) {
            if (it) moveMain()
        }
    }

    private fun moveMain() {
        startActivity(Intent(baseContext, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        })
        finish()
    }
}