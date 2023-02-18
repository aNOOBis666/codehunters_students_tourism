package com.codehunters.network.mapping

import com.codehunters.network.data.requestStudTour.DormitoryEntity
import com.codehunters.network.data.response.ResponseData

fun List<ResponseData>?.toDormitories() = this?.map {
    DormitoryEntity(
        id = it.id.orEmpty(),
        userId = it.userId.orEmpty(),
        universityId = it.universityId.orEmpty(),
        details = it.details.toDetailsWithNesting(),
        onModeration = it.onModeration ?: false,
        createdTimestamp = it.createdTimestamp ?: 0L,
        updatedTimestamp = it.updatedTimestamp ?: 0L,
        timestamp = it.timestamp ?: 0L,
    )
} ?: emptyList()