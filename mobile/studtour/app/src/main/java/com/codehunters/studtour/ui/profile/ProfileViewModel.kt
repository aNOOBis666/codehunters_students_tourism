package com.codehunters.studtour.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codehunters.studtour.interactors.AppInteractor
import com.codehunters.studtour.navigation.INavigation
import com.codehunters.studtour.utils.cancelNullable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val appInteractor: AppInteractor,
    private val navigation: INavigation
) : ViewModel() {

    val isAuthorized: Flow<Boolean>
        get() = appInteractor.isAuthorized

    private var authJob: Job? = null

    fun onShowFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            navigation.onShowFavorites()
        }
    }

    fun onShowReminders() {
        viewModelScope.launch(Dispatchers.IO) {
            navigation.onShowReminders()
        }
    }

    fun onShowUserData() {
        viewModelScope.launch(Dispatchers.IO) {
            navigation.onShowUserData()
        }
    }

    fun onAuthCLick(isAuthorized: Boolean) {
        authJob?.cancelNullable()
        authJob = viewModelScope.launch(Dispatchers.IO) {
            if (isAuthorized) {
                navigation.onShowLogout()
            } else {
                navigation.onShowLogin()
            }

        }
    }
}