package org.cardna.data.remote.model.auth

class ResponseLoginData(

    val message: String,
    val status: Int,
    val success: Boolean,
    val data: Data,
) {
    data class Data(
        val type: String,
        val name: String,
        val code: String,
        val accessToken: String,
        val refreshToken: String
    )
}