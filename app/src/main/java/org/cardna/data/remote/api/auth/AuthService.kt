package org.cardna.data.remote.api.auth

import org.cardna.data.remote.model.auth.RequestLoginData
import org.cardna.data.remote.model.auth.ResponseLoginData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface AuthService {
    @GET("auth/{social}")
    suspend fun getLogin(
        @Path("social") social: String,
    ): ResponseLoginData
}