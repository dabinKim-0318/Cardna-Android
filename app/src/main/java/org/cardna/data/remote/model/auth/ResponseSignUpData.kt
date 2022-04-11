package org.cardna.data.remote.model.auth

class ResponseSignUpData(

    val message: String,
    val status: Int,
    val success: Boolean,
    val data: Data,
) {
    data class Data(
        val type: String,
        val social: String,
        val uuid: String
    )
}