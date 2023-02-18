package com.codehunters.presenter.interfaces

import com.codehunters.data.AuthorizationInfo
import com.codehunters.data.UserInfo
import kotlinx.coroutines.flow.Flow

interface IAuthPresenter {
    val isAuthorized: Flow<Boolean>
    suspend fun loginUser(authInfo: AuthorizationInfo)
    suspend fun registerUser(authInfo: AuthorizationInfo)
    suspend fun logOut()
    suspend fun getMe(): UserInfo
    suspend fun updateMe(userInfo: UserInfo): UserInfo
}