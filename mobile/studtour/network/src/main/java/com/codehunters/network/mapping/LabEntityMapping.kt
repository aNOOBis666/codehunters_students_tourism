package com.codehunters.network.mapping

import com.codehunters.network.data.requestStudTour.LabEntity
import com.codehunters.network.data.response.ResponseLabsData

fun List<ResponseLabsData>?.toLabs() = this?.map {
    LabEntity(
        id = it.id.orEmpty(),
        userId = it.userId.orEmpty(),
        universityId = it.universityId.orEmpty(),
        onModeration = it.onModeration ?: false,
        createdTimestamp = it.createdTimestamp ?: 0L,
        updatedTimestamp = it.updatedTimestamp ?: 0L,
        timestamp = it.timestamp ?: 0L,
        details = it.details.toDetails(),
    )
} ?: emptyList()