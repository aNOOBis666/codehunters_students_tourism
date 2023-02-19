package com.codehunters.repository.auth

import com.codehunters.data.AuthorizationInfo
import com.codehunters.data.UserInfo

interface IAuthRepository {
    suspend fun loginUser(authInfo: AuthorizationInfo): String
    suspend fun registerUser(authInfo: AuthorizationInfo): String
    suspend fun getMe(): UserInfo
    suspend fun updateMe(userInfo: UserInfo): UserInfo
}