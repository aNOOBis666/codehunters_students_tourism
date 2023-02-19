package com.codehunters.studtour.ui.profile.login_input

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codehunters.data.AuthorizationInfo
import com.codehunters.presenter.interfaces.IAuthPresenter
import com.codehunters.studtour.interactors.AppInteractor
import com.codehunters.studtour.navigation.INavigation
import com.codehunters.studtour.utils.cancelNullable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginInputViewModel @Inject constructor(
    private val authorizationPresenter: IAuthPresenter,
    private val appInteractor: AppInteractor,
    private val navigation: INavigation
) : ViewModel() {

    val isAuthorized: Flow<Boolean>
        get() = appInteractor.isAuthorized

    private val _failureState = MutableSharedFlow<Throwable>(replay = 0)
    val failureState = _failureState.asSharedFlow()

    private var loginJob: Job? = null
    private var navigationJob: Job? = null
    private var backNavJob: Job? = null

    fun loginInput(email: String, password: String) {
        loginJob?.cancelNullable()
        loginJob = viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                authorizationPresenter.loginUser(AuthorizationInfo(email, password))
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