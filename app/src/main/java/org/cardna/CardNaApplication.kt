package org.cardna

import android.app.Application
import android.util.Log
import com.example.cardna.BuildConfig
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility
import dagger.hilt.android.HiltAndroidApp
import org.cardna.presentation.util.PixelRatio
import timber.log.Timber

@HiltAndroidApp
class CardNaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initPixelUtil()
        initLogger()
        KakaoSdk.init(this, BuildConfig.KAKAO_NATIVE_APP_KEY)
    Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ",Utility.getKeyHash(this).toString())
    }

    private fun initPixelUtil() {
        pixelRatio = PixelRatio(this)
    }

    private fun initLogger() {
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        lateinit var pixelRatio: PixelRatio
    }
}
