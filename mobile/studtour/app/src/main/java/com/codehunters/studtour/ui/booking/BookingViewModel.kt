package com.codehunters.studtour.ui.booking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codehunters.data.*
import com.codehunters.presenter.interfaces.IStudTourPresenter
import com.codehunters.studtour.interactors.IReminderService
import com.codehunters.studtour.navigation.INavigation
import com.codehunters.studtour.utils.cancelNullable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    private val navigation: INavigation,
    private val studTourInteractor: IStudTourPresenter,
    private val reminderService: IReminderService
) : ViewModel() {

    var roomsList: List<RoomInfo>? = null
    var dormitory: DormitoryInfo? = null

    val startDate: Long? = null
    var selectedStartDate: String? = null
    var selectedEndDate: String? = null
    var selectedType: String? = null

    private var bookingJob: Job? = null

    fun onShowDormitory() {
        viewModelScope.launch(Dispatchers.IO) {
            navigation.back()
        }
    }

    fun onBookRoom(roomId: String) {
        bookingJob?.cancelNullable()
        bookingJob = viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                studTourInteractor.postBooking(
                    BookingInfo(
                        roomId = roomId,
                        quantity = 1,
                        dates = BookingDatesInfo(
                            from = selectedStartDate ?: String(),
                            to = selectedEndDate ?: String()
                        ),
                        status = ""
                    )
                )
            }
        }
    }

    fun onSetReminder(roomId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            reminderService.addReminder(
                Reminder(
                    bookingId = roomId,
                    startTime = startDate ?: 0L,
                    dormitoryPosterUrl = dormitory?.details?.mainInfo?.photoUrls?.firstOrNull()
                        ?: String(),
                    dormitoryName = dormitory?.details?.mainInfo?.name ?: String()
                )
            )
        }
    }
}