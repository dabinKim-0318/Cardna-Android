package org.cardna.presentation.ui.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import com.example.cardna.R
import com.example.cardna.databinding.ActivitySplashBinding
import org.cardna.data.local.singleton.CardNaRepository
import org.cardna.presentation.MainActivity
import org.cardna.presentation.base.BaseViewUtil
import org.cardna.presentation.util.StatusBarUtil

class SplashActivity : BaseViewUtil.BaseAppCompatActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        StatusBarUtil.setStatusBar(this, R.color.black)
        setFullScreen()

        Log.d("ㅡㅡㅡㅡㅡㅡkakaoUserfirstNameㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.kakaoUserfirstName)
        Log.d("ㅡㅡㅡㅡㅡㅡㅡkakaoUserTokenㅡㅡㅡㅡㅡㅡ", CardNaRepository.kakaoUserToken)
        Log.d("ㅡㅡㅡㅡㅡㅡㅡkakaoUserlogOutㅡㅡㅡㅡㅡㅡ", CardNaRepository.kakaoUserlogOut.toString())


        Log.d("ㅡㅡㅡㅡㅡㅡㅡnaverUserfirstNameㅡㅡㅡㅡㅡㅡ", CardNaRepository.naverUserfirstName)
        Log.d("ㅡㅡㅡㅡㅡㅡㅡnaverUserTokenㅡㅡㅡㅡㅡㅡ", CardNaRepository.naverUserToken)
        Log.d("ㅡㅡㅡㅡㅡㅡㅡnaverUserlogOutㅡㅡㅡㅡㅡㅡ", CardNaRepository.naverUserlogOut.toString())

        setNextActivity()
    }

    private fun setFullScreen() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.let {
                it.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    )
        }
    }


    private fun setNextActivity() {
        //모든 소셜에서 이름이 없으면->회원가입 안함
        if (CardNaRepository.kakaoUserfirstName.isEmpty() && CardNaRepository.naverUserfirstName.isEmpty()) {
            Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", "모든 소셜에서 이름이 없으면->회원가입 안함")
            moveOnLogin()

            //카카오로 자동로그인
            //1. 카카오에 이름잇음+카카오에서 로그아웃 안함
        } else if (CardNaRepository.kakaoUserfirstName.isNotEmpty() && !CardNaRepository.kakaoUserlogOut) { //카카오 토큰으로 인터셉트
            CardNaRepository.userToken = CardNaRepository.kakaoUserToken
            Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", "카카오로 자동로그인")
            moveMain()

            //네이버로 자동로그인
            //2.네이버에 이름잇음+네이버에서 로그아웃 안함
        } else if (CardNaRepository.naverUserfirstName.isNotEmpty() && !CardNaRepository.naverUserlogOut) { //네이버 토큰으로 인터셉트
            CardNaRepository.userToken = CardNaRepository.naverUserToken
            Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", "네이버로 자동로그인")
            moveMain()

            //로그아웃
        } else if (CardNaRepository.kakaoUserlogOut || CardNaRepository.naverUserlogOut) {
            Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", "어딘가에서 로그아웃을 햇다")
            moveOnLogin()
        }
    }

    private fun moveOnLogin() {
        val intent = Intent(baseContext, LoginActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startNextActivityWithHandling(intent)
    }

    private fun moveMain() {
        val intent = Intent(baseContext, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startNextActivityWithHandling(intent)
    }

    private fun startNextActivityWithHandling(intent: Intent) {
        Handler(Looper.getMainLooper())
            .postDelayed({
                startActivity(intent)
                finish()
            }, 2000)
    }
}