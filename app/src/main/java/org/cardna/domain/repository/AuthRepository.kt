package org.cardna.domain.repository

import org.cardna.data.remote.model.auth.RequestLoginData
import org.cardna.data.remote.model.auth.ResponseLoginData

interface AuthRepository {
    suspend fun getLogin(social: String, body: RequestLoginData): ResponseLoginData
}