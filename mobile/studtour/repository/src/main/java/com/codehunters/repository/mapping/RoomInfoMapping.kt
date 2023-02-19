package com.codehunters.repository.mapping

import com.codehunters.data.RoomInfo
import com.codehunters.network.data.requestStudTour.RoomEntity

fun List<RoomEntity>.toRoomInfo() = this.map {
    RoomInfo(
        userId = it.userId,
        universityId = it.universityId,
        dormitoryId = it.dormitoryId,
        name = it.name,
        id = it.id,
        timestamp = it.timestamp,
        createdTimestamp = it.createdTimestamp,
        updatedTimestamp = it.updatedTimestamp,
        onModeration = it.onModeration,
        details = it.details.toDetailsInfoMapping()
    )
}