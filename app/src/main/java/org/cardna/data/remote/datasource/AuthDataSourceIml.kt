package org.cardna.data.remote.datasource

import org.cardna.data.remote.api.auth.AuthService
import org.cardna.data.remote.model.auth.RequestLoginData
import org.cardna.data.remote.model.auth.ResponseLoginData
import javax.inject.Inject

class AuthDataSourceIml @Inject constructor(
    private val authService: AuthService
) : AuthDataSource {

    override suspend fun getLogin(social: String): ResponseLoginData {
        return authService.getLogin(social=social)
    }
}

