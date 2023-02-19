package com.codehunters.repository.mapping

import com.codehunters.data.UniversityInfo
import com.codehunters.network.data.requestStudTour.UniversityEntity

fun List<UniversityEntity>.toUniversityInfo() = this.map {
    UniversityInfo(
        id = it.id,
        userId = it.userId,
        name = it.name,
        description = it.description,
        details = it.details.toDetailsInfoMapping(),
        isDebug = it.isDebug,
        onModeration = it.onModeration,
        createdTimestamp = it.createdTimestamp,
        updatedTimestamp = it.updatedTimestamp,
        timestamp = it.timestamp
    )
}