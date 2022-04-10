package org.cardna.data.local.singleton

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey


object CardNaRepository {


    private const val SOCIAL_KEY = "SOCIAL_KEY"
    private const val UUID_KEY = "UUID_KEY"  //유저아이디 저장
    private const val LAST_NAME = "LAST_NAME"
    private const val FIRST_NAME = "FIRST_NAME"

    private const val PREF_KEY = "PREF_KEY"  //보안쉐프 만들떄 쓴키
    private const val AUTH_KEY = "AUTH_KEY"  //유저토큰 키
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
        get() = preferences.getString(AUTH_KEY, "CardNa") ?: ""
        set(value) = preferences.edit { it.putString(AUTH_KEY, value) }

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
    var lastName: String
        get() = authPreferences.getString(LAST_NAME, "") ?: ""
        set(value) = authPreferences.edit { it.putString(LAST_NAME, value) }

    //성
    var firstName: String
        get() = authPreferences.getString(FIRST_NAME, "") ?: ""
        set(value) = authPreferences.edit { it.putString(FIRST_NAME, value) }

    var userTokenㅇ = ""
    //      "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6OSwidXVpZCI6IjExMTExMTExIiwibGFzdE5hbWUiOiLqs70iLCJmaXJzdE5hbWUiOiLrr7zso7wiLCJjb2RlIjoi6rO966-87KO8IzM2ODIiLCJpYXQiOjE2NDg2MzEwNDEsImV4cCI6MTY1MTIyMzA0MSwiaXNzIjoiY2FyZG5hIn0.1FSa5bNolQYC8_pHnA_6dlH_guQEMddPoivLiWD5bYY"
}