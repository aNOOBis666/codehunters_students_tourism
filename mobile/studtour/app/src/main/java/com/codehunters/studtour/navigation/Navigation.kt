package com.codehunters.studtour.navigation

import com.codehunters.data.DormitoryInfo
import com.codehunters.data.RoomInfo
import com.codehunters.studtour.R
import com.codehunters.studtour.ui.booking.BookingFragment
import com.codehunters.studtour.ui.dormitory.DormitoryFragment
import com.codehunters.studtour.ui.profile.registration.RegistrationFragment

class Navigation(
    private val navigationDispatcher: NavDispatcher
): INavigation {
    override suspend fun back() = navigationDispatcher.back()

    override val navigationResetFlow = navigationDispatcher.navigationResetFlow

    override suspend fun onShowFavorites(){
        navigationDispatcher.navigate(R.id.fmt_user_data_destination)
    }
    override suspend fun onShowReminders(){
        navigationDispatcher.navigate(R.id.fmt_favorites_destination)
    }
    override suspend fun onShowUserData(){
        navigationDispatcher.navigate(R.id.fmt_reminders_destination)
    }

    override suspend fun onShowLogin() {
        navigationDispatcher.navigate(R.id.fmt_login_destination)
    }

    override suspend fun onShowLogout() {
        navigationDispatcher.navigate(R.id.dlg_logout_destination)
    }

    override suspend fun onShowLoginInput() {
        navigationDispatcher.navigate(R.id.fmt_login_input_destination)
    }

    override suspend fun onShowRegistration(stepNum: Int) {
        navigationDispatcher.navigate(R.id.fmt_registration_destination, RegistrationFragment.getArgs(stepNum))
    }

    override suspend fun onShowProfile() {
        navigationDispatcher.backTo(R.id.fmt_profile_destination)
    }

    override suspend fun onShowDormitory(dormitoryItem: DormitoryInfo) {
        navigationDispatcher.navigate(R.id.fmt_dormitory_destination, DormitoryFragment.getArgs(dormitoryItem))
    }

    override suspend fun onShowBooking(roomsList: List<RoomInfo>, dormitory: DormitoryInfo) {
        navigationDispatcher.navigate(R.id.fmt_booking_destination, BookingFragment.getArgs(roomsList, dormitory))
    }
}