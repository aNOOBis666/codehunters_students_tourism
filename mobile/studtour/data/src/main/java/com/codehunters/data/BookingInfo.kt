package com.codehunters.data

data class BookingInfo(
    val roomId: String,
    val quantity: Int,
    val dates: BookingDatesInfo,
    val status: String
)