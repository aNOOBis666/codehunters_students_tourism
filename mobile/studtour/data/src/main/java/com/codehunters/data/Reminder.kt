package com.codehunters.data

data class Reminder(
    val id: Int? = -1,
    val bookingId: String,
    val startTime: Long,
    val dormitoryPosterUrl: String,
    val dormitoryName: String,
)