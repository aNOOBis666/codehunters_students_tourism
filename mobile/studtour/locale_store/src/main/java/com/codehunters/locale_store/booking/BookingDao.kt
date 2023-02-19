package com.codehunters.locale_store.booking

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface BookingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addReminder(item: BookingEntity)

    @Query("delete from bookings where bookingId=:bookingId")
    suspend fun deleteReminder(bookingId: String)

    @Query(
        "select * from bookings"
    )
    suspend fun getReminders(): List<BookingEntity>?

    @Query(
        "select * from bookings"
    )
    fun getRemindersFlow(): Flow<List<BookingEntity>>

    @Query(
        "select * from bookings where bookingId=:bookingId"
    )
    suspend fun getById(bookingId: String): BookingEntity?
}