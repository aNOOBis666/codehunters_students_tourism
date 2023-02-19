package com.codehunters.presenter

import com.codehunters.data.AuthorizationInfo
import com.codehunters.data.UserInfo
import com.codehunters.presenter.interfaces.IAuthPresenter
import com.codehunters.repository.auth.IAuthRepository
import com.codehunters.repository.data_store.IDataStoreRepository
import com.codehunters.repository.stud_tour.IStudTourRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthPresenter(
    private val authRepository: IAuthRepository,
    private val studTourRepository: IStudTourRepository,
    private val dataStoreRepository: IDataStoreRepository
) : IAuthPresenter {
    override suspend fun loginUser(authInfo: AuthorizationInfo) {
        val token = authRepository.loginUser(authInfo)
        studTourRepository.setAuthToken(token)
        dataStoreRepository.setAuthToken(token)
    }

    override suspend fun registerUser(authInfo: AuthorizationInfo) {
        val token = authRepository.registerUser(authInfo)
        studTourRepository.setAuthToken(token)
        dataStoreRepository.setAuthToken(token)
    }

    override suspend fun logOut() {
        dataStoreRepository.setAuthToken(String())
    }

    override suspend fun getMe(): UserInfo {
        return authRepository.getMe()
    }

    override suspend fun updateMe(userInfo: UserInfo): UserInfo {
        return authRepository.updateMe(userInfo)
    }

    override val isAuthorized: Flow<Boolean>
        get() = dataStoreRepository.getAuthToken.map { it.isNotEmpty() }
}