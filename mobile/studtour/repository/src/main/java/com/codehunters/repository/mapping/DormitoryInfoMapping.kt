package com.codehunters.repository.mapping

import com.codehunters.data.DormitoryInfo
import com.codehunters.network.data.requestStudTour.DormitoryEntity

fun List<DormitoryEntity>.toDormitoryInfo() = this.map {
    DormitoryInfo(
        id = it.id,
        userId = it.userId,
        timestamp = it.timestamp,
        onModeration = it.onModeration,
        universityId = it.universityId,
        createdTimestamp = it.createdTimestamp,
        updatedTimestamp = it.updatedTimestamp,
        details = it.details.toDetailsInfoMapping()
    )
}