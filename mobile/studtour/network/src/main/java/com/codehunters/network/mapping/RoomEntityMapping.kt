package com.codehunters.network.mapping

import com.codehunters.network.data.requestStudTour.RoomEntity
import com.codehunters.network.data.response.ResponseData

fun List<ResponseData>?.toRooms() = this?.map {
    RoomEntity(
        id = it.id.orEmpty(),
        userId = it.userId.orEmpty(),
        universityId = it.universityId.orEmpty(),
        dormitoryId = it.dormitoryId.orEmpty(),
        name = it.name.orEmpty(),
        onModeration = it.onModeration ?: false,
        createdTimestamp = it.createdTimestamp ?: 0L,
        updatedTimestamp = it.updatedTimestamp ?: 0L,
        timestamp = it.timestamp ?: 0L,
        details = it.details.toDetails()
    )
} ?: emptyList()