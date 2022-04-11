package org.cardna.data.repository

import org.cardna.data.remote.datasource.AuthDataSource
import org.cardna.data.remote.model.auth.RequestAuthData
import org.cardna.data.remote.model.auth.ResponseAuthData
import org.cardna.data.remote.model.auth.ResponseSignInData
import org.cardna.data.remote.model.auth.ResponseSignUpData
import org.cardna.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authDataSource: AuthDataSource) :
    AuthRepository {

    override suspend fun getSignUp(social: String): ResponseSignUpData {
        return authDataSource.getSignUp(social = social)
    }

    override suspend fun postAuth(body: RequestAuthData): ResponseAuthData {
        return authDataSource.postAuth(body = body)
    }

    override suspend fun getSignIn(social: String): ResponseSignInData {
        return authDataSource.getSignIn(social = social)
    }
}