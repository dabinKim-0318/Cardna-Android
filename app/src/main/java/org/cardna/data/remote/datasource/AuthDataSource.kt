package org.cardna.data.remote.datasource

import org.cardna.data.remote.model.auth.RequestAuthData
import org.cardna.data.remote.model.auth.ResponseAuthData
import org.cardna.data.remote.model.auth.ResponseSignInData
import org.cardna.data.remote.model.auth.ResponseSignUpData

interface AuthDataSource {
    suspend fun getSignUp(social: String): ResponseSignUpData
    suspend fun getSignIn(social: String): ResponseSignInData
    suspend fun postAuth(body: RequestAuthData ): ResponseAuthData
}