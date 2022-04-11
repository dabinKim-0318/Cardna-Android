package org.cardna.data.remote.datasource

import org.cardna.data.remote.api.auth.AuthService
import org.cardna.data.remote.model.auth.RequestAuthData
import org.cardna.data.remote.model.auth.ResponseAuthData
import org.cardna.data.remote.model.auth.ResponseSignInData
import org.cardna.data.remote.model.auth.ResponseSignUpData
import javax.inject.Inject

class AuthDataSourceIml @Inject constructor(
    private val authService: AuthService
) : AuthDataSource {

    override suspend fun getSignUp(social: String): ResponseSignUpData {
        return authService.getSignUp(social=social)
    }

    override suspend fun postAuth(body: RequestAuthData): ResponseAuthData {
        return authService.postAuth(body=body)
    }

    override suspend fun getSignIn(social: String): ResponseSignInData {
        return authService.getSignIn(social=social)
    }
}

