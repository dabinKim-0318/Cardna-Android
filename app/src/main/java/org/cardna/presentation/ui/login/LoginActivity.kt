package org.cardna.presentation.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.cardna.R
import com.example.cardna.databinding.ActivityLoginBinding
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.AndroidEntryPoint
import org.cardna.presentation.base.BaseViewUtil
import org.cardna.presentation.ui.login.viewmodel.LogInViewModel

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

    }

    private fun setKakaoLogin() {
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Log.e("kakao login error", "카카오 로그인 실패", error)
            } else if (token != null) {
                UserApiClient.instance.me { user, error ->
                    val accessToken = token.accessToken
                    val refreshToken = token.refreshToken
                    Log.e("kakao login", token.accessToken)
                    Log.e("kakao login", token.refreshToken)
                    loginViewModel.loginWithKakao(accessToken)
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
        loginViewModel.kakaoLogInSuccess.observe(this) {
            if (it) startActivity(Intent(this@LoginActivity, SetNameActivity::class.java))
        }
    }
}