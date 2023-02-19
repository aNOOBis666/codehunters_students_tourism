package com.codehunters.repository.reminders

import com.codehunters.data.Reminder
import com.codehunters.locale_store.booking.BookingDatabase
import com.codehunters.locale_store.booking.BookingEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemindersRepository @Inject constructor(
    private val db: BookingDatabase,
): IRemindersRepository{
    override suspend fun addReminder(item: Reminder) {
        db.bookingDao.addReminder(
            BookingEntity(
                bookingId = item.bookingId,
                startTime = item.startTime,
                dormitoryPosterUrl = item.dormitoryPosterUrl,
                dormitoryName = item.dormitoryName
            )
        )
    }

    override suspend fun deleteReminder(bookingId: String) {
        db.bookingDao.deleteReminder(bookingId)
    }

    override suspend fun getRemindersFlow(): Flow<List<Reminder>> =
        db.bookingDao.getRemindersFlow().map { list ->
            list.map { entity -> entity.toReminder() }
        }

    override suspend fun getById(bookingId: String): Reminder? {
        return db.bookingDao.getById(bookingId)?.toReminder()
    }

    override suspend fun getReminders(): List<Reminder>? {
        return db.bookingDao.getReminders()?.toReminders()
    }

    private fun List<BookingEntity>?.toReminders() = this?.map { it.toReminder() }
    private fun BookingEntity?.toReminder() = Reminder(
        id = this?.id ?: 0,
        bookingId = this?.bookingId ?: String(),
        startTime = this?.startTime ?: 0L,
        dormitoryPosterUrl = this?.dormitoryPosterUrl ?: String(),
        dormitoryName = this?.dormitoryName ?: String()
    )
}