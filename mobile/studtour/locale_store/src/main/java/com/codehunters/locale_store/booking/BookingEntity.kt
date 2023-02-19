package com.codehunters.locale_store.booking

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookings")
data class BookingEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val bookingId: String? = null,
    val startTime: Long? = null,
    val dormitoryPosterUrl: String? = null,
    val dormitoryName: String? = null,
)