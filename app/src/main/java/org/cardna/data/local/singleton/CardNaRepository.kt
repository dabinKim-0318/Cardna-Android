package org.cardna.data.local.singleton

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey


object CardNaRepository {


    private const val SOCIAL_KEY = "SOCIAL_KEY"
    private const val UUID_KEY = "UUID_KEY"  //유저아이디 저장
    private const val FIRST_NAME = "FIRST_NAME"
    private const val LOG_OUT = "LOG_OUT"

    private const val PREF_KEY = "PREF_KEY"  //보안쉐프 만들떄 쓴키
    private const val UT_KEY = "UT_KEY"  //유저토큰 키
    private const val URT_KEY = "URT_KEY"  //유저토큰 키
    private const val FB_KEY = "FB_TOKEN" //파이어베이슨 토큰 키

    private lateinit var preferences: SharedPreferences
    private lateinit var authPreferences: SharedPreferences
    private lateinit var masterKeyAlias: MasterKey


    fun init(context: Context) {
        masterKeyAlias = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()


        preferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
        authPreferences = EncryptedSharedPreferences.create(
            context,
            PREF_KEY,
            masterKeyAlias,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    //유저 토큰
    var userToken: String
        get() = preferences.getString(UT_KEY, "") ?: ""
        set(value) = preferences.edit { it.putString(UT_KEY, value) }

    //유저 리프레시 토큰
    var userRefreshToken: String
        get() = preferences.getString(URT_KEY, "") ?: ""
        set(value) = preferences.edit { it.putString(URT_KEY, value) }

    //파이어베이스 토큰
    var fireBaseToken: String
        get() = preferences.getString(FB_KEY, "FireCardNa") ?: ""
        set(value) = preferences.edit { it.putString(FB_KEY, value) }

    //유저아이디
    var uuId: String
        get() = authPreferences.getString(UUID_KEY, "") ?: ""
        set(value) = authPreferences.edit { it.putString(UUID_KEY, value) }

    //소셜 플랙폼
    var social: String
        get() = authPreferences.getString(SOCIAL_KEY, "") ?: ""
        set(value) = authPreferences.edit { it.putString(SOCIAL_KEY, value) }

    //이름
    var firstName: String
        get() = authPreferences.getString(FIRST_NAME, "") ?: ""
        set(value) = authPreferences.edit { it.putString(FIRST_NAME, value) }

    //이름
    var logOut: Boolean
        get() = preferences.getBoolean(LOG_OUT, false)
        set(value) = preferences.edit { it.putBoolean(LOG_OUT, value) }

}