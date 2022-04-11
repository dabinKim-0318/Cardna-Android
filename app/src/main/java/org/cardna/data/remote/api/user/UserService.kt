package org.cardna.data.remote.api.user

import org.cardna.data.remote.model.like.RequestLikeData
import org.cardna.data.remote.model.like.ResponseLikeData
import org.cardna.data.remote.model.user.RequestDeleteUserData
import org.cardna.data.remote.model.user.RequestPostReportUserData
import org.cardna.data.remote.model.user.ResponseDeleteUserData
import org.cardna.data.remote.model.user.ResponsePostReportUserData
import retrofit2.http.*

interface UserService {

    @HTTP(method = "DELETE", path = "user", hasBody = true)
    suspend fun deleteUser(
        @Body body: RequestDeleteUserData
    ): ResponseDeleteUserData

    @POST("user/report")
    suspend fun postReportUser(
        @Body body: RequestPostReportUserData
    ): ResponsePostReportUserData
}