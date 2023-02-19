package com.codehunters.studtour.interactors

import com.codehunters.data.Reminder

interface IReminderService {
    suspend fun addReminder(reminder: Reminder)
    suspend fun deleteReminder(reminder: Reminder)
    fun restoreReminders()
}