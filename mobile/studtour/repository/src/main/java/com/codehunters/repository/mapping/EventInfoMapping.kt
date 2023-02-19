package com.codehunters.repository.mapping

import com.codehunters.data.EventInfo
import com.codehunters.network.data.requestStudTour.EventEntity

fun List<EventEntity>.toEventInfo() = this.map {
    EventInfo(
        id = it.id ,
        userId = it.userId ,
        universityId = it.universityId ,
        onModeration = it.onModeration ,
        createdTimestamp = it.createdTimestamp ,
        updatedTimestamp = it.updatedTimestamp ,
        timestamp = it.timestamp ,
        details = it.details.toDetailsInfoMapping()
    )
}