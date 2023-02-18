package com.codehunters.repository.auth

import com.codehunters.data.AuthorizationInfo
import com.codehunters.data.UserInfo
import com.codehunters.network.services.IAuthService
import com.codehunters.repository.mapping.toAuthorizationEntity
import com.codehunters.repository.mapping.toUserEntity
import com.codehunters.repository.mapping.toUserInfo

class AuthRepository(
    private val authService: IAuthService
): IAuthRepository {

    override suspend fun loginUser(authInfo: AuthorizationInfo): String {
        return authService.loginUser(authInfo.toAuthorizationEntity())
    }

    override suspend fun registerUser(authInfo: AuthorizationInfo): String {
        return authService.registerUser(authInfo.toAuthorizationEntity())
    }

    override suspend fun getMe(): UserInfo {
        return authService.getMe().toUserInfo()
    }

    override suspend fun updateMe(userInfo: UserInfo): UserInfo {
        return authService.updateMe(userInfo.toUserEntity()).toUserInfo()
    }
}