package org.cardna.data.remote.api.auth

import org.cardna.data.remote.model.auth.RequestAuthData
import org.cardna.data.remote.model.auth.RequestLoginData
import org.cardna.data.remote.model.auth.ResponseAuthData
import org.cardna.data.remote.model.auth.ResponseLoginData
import org.cardna.data.remote.model.user.RequestPostReportUserData
import org.cardna.data.remote.model.user.ResponsePostReportUserData
import retrofit2.http.*

interface AuthService {
    @GET("auth/{social}")
    suspend fun getLogin(
        @Path("social") social: String,
    ): ResponseLoginData

    @POST("auth")
    suspend fun postAuth(
        @Body body: RequestAuthData
    ): ResponseAuthData
}