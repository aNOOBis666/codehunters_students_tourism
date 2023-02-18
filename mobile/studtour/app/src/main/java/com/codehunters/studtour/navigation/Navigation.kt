package com.codehunters.studtour.navigation

import androidx.annotation.IdRes
import com.codehunters.studtour.R
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
}