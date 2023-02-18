package com.codehunters.network.mapping

import com.codehunters.network.data.requestStudTour.ReviewEntity
import com.codehunters.network.data.response.ResponseData

fun List<ResponseData>?.toReviews() = this?.map {
    ReviewEntity(
        id = it.id.orEmpty(),
        userId = it.userId.orEmpty(),
        universityId = it.universityId.orEmpty(),
        dormitoryId = it.dormitoryId.orEmpty(),
        eventId = it.eventId.orEmpty(),
        photos = it.photosUrls ?: emptyList(),
        topic = it.topic.orEmpty(),
        text = it.text.orEmpty(),
        rating = it.rating ?: 0,
        published = it.published ?: false,
        onModeration = it.onModeration ?: false,
        createdTimestamp = it.createdTimestamp ?: 0L,
        updatedTimestamp = it.updatedTimestamp ?: 0L,
        timestamp = it.timestamp ?: 0L
    )
} ?: emptyList()