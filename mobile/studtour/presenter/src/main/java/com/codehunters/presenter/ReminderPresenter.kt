package com.codehunters.presenter

import com.codehunters.data.Reminder
import com.codehunters.presenter.interfaces.IReminderPresenter
import com.codehunters.repository.reminders.IRemindersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReminderPresenter @Inject constructor(
    private val reminderRepository: IRemindersRepository
): IReminderPresenter {

    override suspend fun addReminder(item: Reminder) {
        reminderRepository.addReminder(item)
    }

    override suspend fun deleteReminder(bookingId: String) {
        reminderRepository.deleteReminder(bookingId)
    }

    override suspend fun getById(bookingId: String): Reminder? {
        return reminderRepository.getById(bookingId)
    }

    override suspend fun getReminders(): List<Reminder>? {
        return reminderRepository.getReminders()
    }

    override suspend fun getRemindersFlow(): Flow<List<Reminder>> {
        return reminderRepository.getRemindersFlow()
    }

}