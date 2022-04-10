package org.cardna.data.remote.model.auth

class ResponseAuthData(

    val message: String,
    val status: Int,
    val success: Boolean,
    val data: Data,
) {
    data class Data(
        val name: String,
        val code: String,
        val accessToken: String,
        val refreshToken: String
    )
}