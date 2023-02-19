package com.codehunters.presenter.interfaces

import com.codehunters.data.Reminder
import kotlinx.coroutines.flow.Flow

interface IReminderPresenter {
    suspend fun addReminder(item: Reminder)
    suspend fun deleteReminder(bookingId: String)
    suspend fun getRemindersFlow(): Flow<List<Reminder>>
    suspend fun getById(bookingId: String): Reminder?
    suspend fun getReminders(): List<Reminder>?
}