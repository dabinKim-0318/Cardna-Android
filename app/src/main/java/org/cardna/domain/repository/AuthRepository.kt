package org.cardna.domain.repository

import org.cardna.data.remote.model.auth.RequestAuthData
import org.cardna.data.remote.model.auth.RequestLoginData
import org.cardna.data.remote.model.auth.ResponseAuthData
import org.cardna.data.remote.model.auth.ResponseLoginData

interface AuthRepository {
    suspend fun getLogin(social: String): ResponseLoginData
    suspend fun postAuth(body: RequestAuthData): ResponseAuthData
}