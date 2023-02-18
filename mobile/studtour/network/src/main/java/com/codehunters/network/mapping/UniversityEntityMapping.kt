package com.codehunters.network.mapping

import com.codehunters.network.data.requestStudTour.UniversityEntity
import com.codehunters.network.data.response.ResponseUniversityData

fun List<ResponseUniversityData>?.toUniversities() = this?.map {
    UniversityEntity(
        id = it.id.orEmpty(),
        userId = it.userId.orEmpty(),
        name = it.name.orEmpty(),
        description = it.description.orEmpty(),
        details = it.details.toDetails(),
        isDebug = it.isDebug ?: false,
        onModeration = it.onModeration ?: false,
        createdTimestamp = it.createdTimestamp ?: 0L,
        updatedTimestamp = it.updatedTimestamp ?: 0L,
        timestamp = it.timestamp ?: 0L
    )
} ?: emptyList()