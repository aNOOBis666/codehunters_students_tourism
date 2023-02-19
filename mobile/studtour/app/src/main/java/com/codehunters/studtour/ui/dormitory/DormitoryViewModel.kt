package com.codehunters.studtour.ui.dormitory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codehunters.data.DormitoryInfo
import com.codehunters.data.EntitiesData
import com.codehunters.data.RoomInfo
import com.codehunters.presenter.interfaces.IStudTourPresenter
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
class DormitoryViewModel @Inject constructor(
    private val appInteractor: AppInteractor,
    private val studTourPresenter: IStudTourPresenter,
    private val navigation: INavigation
): ViewModel() {

    var dormitoryItem: DormitoryInfo? = null

    val isAuthorized: Flow<Boolean>
        get() = appInteractor.isAuthorized

    private val _uiState = MutableStateFlow<List<RoomInfo>>(emptyList())
    val uiState = _uiState.asStateFlow()

    private val _failureState = MutableSharedFlow<Throwable>(replay = 0)
    val failureState = _failureState.asSharedFlow()

    private var roomsJob: Job? = null

    init {
        loadRooms()
    }

    fun onShowBooking() {
        viewModelScope.launch(Dispatchers.IO) {
            dormitoryItem?.let { navigation.onShowBooking(uiState.value, it) }
        }
    }

    fun onShowBack() {
        viewModelScope.launch(Dispatchers.IO) {
            navigation.back()
        }
    }


    private fun loadRooms() {
        roomsJob?.cancelNullable()
        roomsJob = viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                dormitoryItem?.id?.let { studTourPresenter.getRooms(it) }
            }.onSuccess {
                if (it != null) {
                    _uiState.value = it
                }
            }.onFailure {
                _failureState.tryEmit(it)
            }
        }
    }
}