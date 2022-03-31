package org.cardna.data.remote.model.friend


data class ResponseFriendNameData(
    val message: String,
    val status: Int,
    val success: Boolean,
    val data: Data,
) {
    data class Data(
        val id: Int,
        val name: String,
        val sentence: String,
        val userImg: String
    )
}