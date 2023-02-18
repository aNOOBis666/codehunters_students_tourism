package com.codehunters.network.apiservice

import com.codehunters.network.data.response.AuthData
import com.codehunters.network.data.response.ResponseToken
import com.codehunters.network.data.response.UserData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface AuthApiService {

    //  Register new user
    @POST("users/signup")
    suspend fun registerUser(
        @Body authData: AuthData
    ): Response<ResponseToken>

    //  Authorize user by email and password
    @POST("users/login")
    suspend fun loginUser(
        @Body authData: AuthData
    ): Response<ResponseToken>

    //  Receive Users info
    @GET("me")
    suspend fun getMe(): Response<UserData>

    //  Updates users info
    @PUT("users")
    suspend fun updateMe(
        @Body userData: UserData
    ): Response<UserData>
}