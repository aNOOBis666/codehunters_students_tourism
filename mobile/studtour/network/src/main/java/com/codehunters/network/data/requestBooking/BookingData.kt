package com.codehunters.network.data.requestBooking

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookingData (
    @SerialName("roomId")
    val roomId: String? = null,
    @SerialName("quantity")
    val quantity: Int = 1,
    @SerialName("dates")
    val dates: DatesData? = null,
    @SerialName("status")
    val status: String? = null
)