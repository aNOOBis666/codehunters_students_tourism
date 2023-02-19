package com.codehunters.locale_store.booking

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [BookingEntity::class],
    version = 1,
    exportSchema = false
)
abstract class BookingDatabase : RoomDatabase() {
    abstract val bookingDao: BookingDao
}