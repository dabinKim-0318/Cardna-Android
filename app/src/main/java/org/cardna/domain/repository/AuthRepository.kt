package org.cardna.domain.repository

import org.cardna.data.remote.model.auth.RequestAuthData
import org.cardna.data.remote.model.auth.ResponseAuthData
import org.cardna.data.remote.model.auth.ResponseSignInData
import org.cardna.data.remote.model.auth.ResponseSignUpData

interface AuthRepository {
    suspend fun getSignUp(social: String): ResponseSignUpData
    suspend fun postAuth(body: RequestAuthData): ResponseAuthData
    suspend fun getSignIn(social: String): ResponseSignInData
}