package org.cardna

import android.app.Application
import android.util.Log
import com.example.cardna.BuildConfig
import com.google.android.gms.tasks.OnCompleteListener
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.HiltAndroidApp
import org.cardna.data.local.singleton.CardNaRepository
import org.cardna.presentation.util.PixelRatio
import timber.log.Timber

@HiltAndroidApp
class CardNaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initPixelUtil()
        initLogger()
        CardNaRepository.init(this)
        KakaoSdk.init(this, BuildConfig.KAKAO_NATIVE_APP_KEY)
        getFirebaseToken()
    }

    private fun initPixelUtil() {
        pixelRatio = PixelRatio(this)
    }

    private fun initLogger() {
        Timber.plant(Timber.DebugTree())
    }

    private fun getFirebaseToken(){
        //파이어베이스 등록 후 다시 실행
/*        FirebaseMessaging.getInstance().token.addOnCompleteListener(
            OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Timber.tag("CardNaRepository.TAG").w(task.exception, "Fetching FCM registration token failed")
                    return@OnCompleteListener
                } else {
                    val token = task.result
                    CardNaRepository.fireBaseToken = token ?: "SomeThing"
                    Timber.e(token.toString())
                }
            }
        )*/
    }

    companion object {
        lateinit var pixelRatio: PixelRatio
    }
}
