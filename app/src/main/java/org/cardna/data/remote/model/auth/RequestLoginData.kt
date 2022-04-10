package org.cardna.data.remote.model.auth

import com.google.gson.annotations.SerializedName

data class RequestLoginData(
    @SerializedName("social") val social: String,
)