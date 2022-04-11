package org.cardna.data.remote.api.auth

import org.cardna.data.remote.model.auth.RequestAuthData
import org.cardna.data.remote.model.auth.ResponseAuthData
import org.cardna.data.remote.model.auth.ResponseSignInData
import org.cardna.data.remote.model.auth.ResponseSignUpData
import retrofit2.http.*

interface AuthService {
    @GET("auth/{social}")
    suspend fun getSignUp(
        @Path("social") social: String,
    ): ResponseSignUpData

    @GET("auth/{social}")
    suspend fun getSignIn(
        @Path("social") social: String,
    ): ResponseSignInData

    @POST("auth")
    suspend fun postAuth(
        @Body body: RequestAuthData
    ): ResponseAuthData
}