package com.codehunters.repository.mapping

import com.codehunters.data.LabInfo
import com.codehunters.network.data.requestStudTour.LabEntity

fun List<LabEntity>.toLabInfo() = this.map {
    LabInfo(
        id = it.id,
        userId = it.userId,
        universityId = it.universityId,
        onModeration = it.onModeration,
        createdTimestamp = it.createdTimestamp,
        updatedTimestamp = it.updatedTimestamp,
        timestamp = it.timestamp,
        details = it.details.toDetailsInfoMapping(),
    )
}