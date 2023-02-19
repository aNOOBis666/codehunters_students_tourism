package com.codehunters.studtour.interactors

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import com.codehunters.data.Reminder
import com.codehunters.presenter.interfaces.IReminderPresenter
import com.codehunters.studtour.reminders.RemindersReceiver
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ReminderService @Inject constructor(
    private val context: Context,
    private val reminderPresenter: IReminderPresenter
) : IReminderService {

    companion object {
        private const val REMINDER_TIME_DELAY = 7 * 24 * 60 * 60 * 100
    }

    private val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    private var alarmManager: AlarmManager =
        context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    @RequiresApi(Build.VERSION_CODES.M)
    override suspend fun addReminder(reminder: Reminder) {
        with(reminderPresenter) {
            addReminder(reminder)

            //  The reminder is first stored in the database, and then
            //  received from the database with an already generated id

            getById(reminder.bookingId)?.let { savedReminder ->
                addReminderToAlarmManager(savedReminder)
            }
        }
    }

    override suspend fun deleteReminder(reminder: Reminder) {
        reminderPresenter.getById(reminder.bookingId)?.let { savedReminder ->
            deleteReminderFromAlarmManager(savedReminder)
            reminderPresenter.deleteReminder(savedReminder.bookingId)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun restoreReminders() {
        scope.launch {
            restoreRemindersToAlarmManager()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun addReminderToAlarmManager(reminder: Reminder) {
        val reminderTime: Long = reminder.startTime - REMINDER_TIME_DELAY
        val pendingIntent: PendingIntent = createPendingIntent(reminder)
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, reminderTime, pendingIntent)
    }

    private fun deleteReminderFromAlarmManager(reminder: Reminder) {
        val pendingIntent: PendingIntent = createPendingIntent(reminder)
        alarmManager.cancel(pendingIntent)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private suspend fun restoreRemindersToAlarmManager() {
        deleteRemindersFromAlarmManager()
        reminderPresenter.getReminders()?.let { reminders ->
            val currentTime = System.currentTimeMillis()
            for (reminder in reminders) {
                if ((reminder.startTime - REMINDER_TIME_DELAY) > currentTime) {
                    addReminderToAlarmManager(reminder)
                } else {
                    reminderPresenter.deleteReminder(reminder.bookingId)
                }
            }
        }
    }

    private suspend fun deleteRemindersFromAlarmManager() {
        reminderPresenter.getReminders()?.let { reminders ->
            for (reminder in reminders) {
                deleteReminderFromAlarmManager(reminder)
            }
        }
    }

    private fun createPendingIntent(item: Reminder): PendingIntent {
        val reminderIntent = Intent(context, RemindersReceiver::class.java).apply {
            putExtras(
                bundleOf(
                    RemindersReceiver.ID to item.id,
                    RemindersReceiver.BOOKING_ID to item.bookingId,
                    RemindersReceiver.START_TIME to item.startTime,
                    RemindersReceiver.DORMITORY_POSTER_URL to item.dormitoryPosterUrl,
                    RemindersReceiver.DORMITORY_NAME to item.dormitoryName,
                )
            )
        }
        return PendingIntent.getBroadcast(
            context,
            item.id ?: 0,
            reminderIntent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
    }
}