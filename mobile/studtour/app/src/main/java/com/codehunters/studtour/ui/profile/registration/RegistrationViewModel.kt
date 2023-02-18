package com.codehunters.studtour.ui.profile.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codehunters.data.AuthorizationInfo
import com.codehunters.presenter.interfaces.IAuthPresenter
import com.codehunters.studtour.navigation.INavigation
import com.codehunters.studtour.utils.cancelNullable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val authorizationPresenter: IAuthPresenter,
    private val navigation: INavigation
): ViewModel() {

    private val _failureState = MutableSharedFlow<Throwable>(replay = 0)
    val failureState = _failureState.asSharedFlow()

    var stepNum: Int? = 0

    private var registrationJob: Job? = null
    private var navigationJob: Job? = null
    private var backNavJob: Job? = null

    fun registerUser(email: String, password: String) {
        registrationJob?.cancelNullable()
        registrationJob = viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                authorizationPresenter.registerUser(AuthorizationInfo(email, password))
            }.onFailure {
                _failureState.tryEmit(it)
            }
        }
    }

    fun onShowProfile() {
        navigationJob?.cancelNullable()
        navigationJob = viewModelScope.launch(Dispatchers.IO) {
            navigation.onShowProfile()
        }
    }

    fun onShowPrevious() {
        backNavJob?.cancelNullable()
        backNavJob = viewModelScope.launch(Dispatchers.IO) {
            navigation.back()
        }
    }
}