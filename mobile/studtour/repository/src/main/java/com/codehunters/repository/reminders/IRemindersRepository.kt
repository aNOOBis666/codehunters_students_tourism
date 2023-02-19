package com.codehunters.repository.reminders

import com.codehunters.data.Reminder
import kotlinx.coroutines.flow.Flow

interface IRemindersRepository {
    suspend fun addReminder(item: Reminder)
    suspend fun deleteReminder(bookingId: String)
    suspend fun getRemindersFlow(): Flow<List<Reminder>>
    suspend fun getById(bookingId: String): Reminder?
    suspend fun getReminders(): List<Reminder>?
}