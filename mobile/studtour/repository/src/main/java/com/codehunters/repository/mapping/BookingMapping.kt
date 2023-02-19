package com.codehunters.repository.mapping

import com.codehunters.data.BookingInfo
import com.codehunters.network.data.requestBooking.BookingData
import com.codehunters.network.data.requestBooking.DatesData

fun BookingInfo.toBookingData() = BookingData(
    roomId = roomId,
    quantity = quantity,
    dates = DatesData(
        from = dates.from,
        to = dates.to
    ),
    status = status
)