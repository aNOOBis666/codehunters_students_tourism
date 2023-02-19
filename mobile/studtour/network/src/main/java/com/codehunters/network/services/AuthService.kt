package com.codehunters.network.services

import com.codehunters.network.apiservice.AuthApiService
import com.codehunters.network.data.requestAuth.AuthEntity
import com.codehunters.network.data.requestAuth.UserEntity
import com.codehunters.network.interceptors.AuthorizationInterceptor
import com.codehunters.network.mapping.toBody
import com.codehunters.network.mapping.toUserEntity
import com.codehunters.network.requestStatus
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthService(
    baseUrl: String,
    okHttp: OkHttpClient.Builder,
    converterFactory: Converter.Factory
) : IAuthService {

    private val authInterceptor = AuthorizationInterceptor()

    private val client = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttp.apply { addInterceptor(authInterceptor) }.build())
        .addConverterFactory(converterFactory)
        .build()
        .create(AuthApiService::class.java)

    private fun setAuthToken(token: String) {
        authInterceptor.authToken = token
    }

    override suspend fun registerUser(authEntity: AuthEntity): String {
        val response = client.registerUser(authEntity.toBody()).requestStatus()?.token ?: String()
        setAuthToken(response)
        return response
    }

    override suspend fun loginUser(authEntity: AuthEntity): String {
        val response = client.loginUser(authEntity.toBody()).requestStatus()?.token ?: String()
        setAuthToken(response)
        return response
    }

    override suspend fun getMe(): UserEntity {
        return client.getMe().requestStatus().toUserEntity()
    }

    override suspend fun updateMe(userEntity: UserEntity): UserEntity {
        return client.updateMe(userEntity.toBody()).requestStatus().toUserEntity()
    }
}