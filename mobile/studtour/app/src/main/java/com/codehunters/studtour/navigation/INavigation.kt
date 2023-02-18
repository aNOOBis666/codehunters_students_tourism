package com.codehunters.studtour.navigation

import kotlinx.coroutines.flow.Flow

interface INavigation {
    suspend fun back()
    val navigationResetFlow: Flow<Int>

    suspend fun onShowFavorites()
    suspend fun onShowReminders()
    suspend fun onShowUserData()

    suspend fun onShowLogin()
    suspend fun onShowLogout()
    suspend fun onShowLoginInput()
    suspend fun onShowRegistration()

    suspend fun onShowProfile()
}