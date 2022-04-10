package org.cardna.data.remote.datasource

import org.cardna.data.remote.model.auth.RequestAuthData
import org.cardna.data.remote.model.auth.RequestLoginData
import org.cardna.data.remote.model.auth.ResponseAuthData
import org.cardna.data.remote.model.auth.ResponseLoginData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthDataSource {
    suspend fun getLogin(social: String): ResponseLoginData
    suspend fun postAuth(body: RequestAuthData ): ResponseAuthData
}