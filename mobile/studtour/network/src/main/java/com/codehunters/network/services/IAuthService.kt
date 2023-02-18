package com.codehunters.network.services

import com.codehunters.network.data.requestAuth.AuthEntity
import com.codehunters.network.data.requestAuth.UserEntity

interface IAuthService {
    suspend fun registerUser(authEntity: AuthEntity): String
    suspend fun loginUser(authEntity: AuthEntity): String
    suspend fun getMe(): UserEntity
    suspend fun updateMe(userEntity: UserEntity): UserEntity
}