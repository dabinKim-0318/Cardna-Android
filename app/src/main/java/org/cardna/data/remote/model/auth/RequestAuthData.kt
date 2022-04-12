package org.cardna.data.remote.model.auth

import com.google.gson.annotations.SerializedName
import org.cardna.data.local.singleton.CardNaRepository

data class RequestAuthData(
    @SerializedName("social") val social: String = CardNaRepository.userSocial,
    @SerializedName("uuid") val uuid: String = CardNaRepository.userUuid,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("deviceToken") val deviceToken: String = CardNaRepository.fireBaseToken
)