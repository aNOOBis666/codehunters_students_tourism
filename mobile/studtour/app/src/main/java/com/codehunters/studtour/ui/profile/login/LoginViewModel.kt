package com.codehunters.studtour.ui.profile.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codehunters.studtour.navigation.INavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigation: INavigation
) : ViewModel() {

    fun onShowRegistration() {
        viewModelScope.launch(Dispatchers.IO) {
            navigation.onShowLoginInput()
        }
    }

    fun onShowLogin() {
        viewModelScope.launch(Dispatchers.IO) {
            navigation.onShowLoginInput()
        }
    }
}