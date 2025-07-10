package com.app.data.remote

import retrofit2.http.GET
import com.app.common.AppCons.USER_END

interface UserApiService {
    @GET(USER_END)
    suspend fun getUserList(): UserResponseDto
}

