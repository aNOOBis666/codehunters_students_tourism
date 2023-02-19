package com.codehunters.studtour.ui.profile.logout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codehunters.studtour.interactors.AppInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogoutViewModel @Inject constructor(
    private val appInteractor: AppInteractor
): ViewModel() {

    fun logout() {
        viewModelScope.launch(Dispatchers.IO) {
            appInteractor.logOut()
        }
    }
}