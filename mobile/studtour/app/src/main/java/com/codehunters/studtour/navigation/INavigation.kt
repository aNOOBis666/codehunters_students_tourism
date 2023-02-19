package com.codehunters.studtour.navigation

import com.codehunters.data.DormitoryInfo
import com.codehunters.data.RoomInfo
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
    suspend fun onShowRegistration(stepNum: Int)

    suspend fun onShowProfile()
    suspend fun onShowDormitory(dormitoryItem: DormitoryInfo)
    suspend fun onShowBooking(roomsList: List<RoomInfo>, dormitory: DormitoryInfo)
}