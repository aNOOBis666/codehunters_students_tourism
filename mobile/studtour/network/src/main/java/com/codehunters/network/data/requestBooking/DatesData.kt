package com.codehunters.network.data.requestBooking

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DatesData (
    @SerialName("from")
    val from: String? = null,
    @SerialName("to")
    val to: String? = null
)