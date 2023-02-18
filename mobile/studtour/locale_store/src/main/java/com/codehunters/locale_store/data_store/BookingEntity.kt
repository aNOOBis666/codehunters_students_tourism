package com.codehunters.locale_store.data_store

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookings")
data class BookingEntity(
    @PrimaryKey(autoGenerate = true)
    val _id: Int,
    val bookingId: Int,
    val title: String,
    val targetDate: Long,
)