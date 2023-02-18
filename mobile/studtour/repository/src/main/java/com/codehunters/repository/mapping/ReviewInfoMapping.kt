package com.codehunters.repository.mapping

import com.codehunters.data.ReviewInfo
import com.codehunters.network.data.requestStudTour.ReviewEntity

fun List<ReviewEntity>.toReviewInfo() = this.map {
    ReviewInfo(
        id = it.id,
        userId = it.userId,
        universityId = it.universityId,
        dormitoryId = it.dormitoryId,
        eventId = it.eventId,
        photos = it.photos,
        topic = it.topic,
        text = it.text,
        rating = it.rating,
        published = it.published,
        onModeration = it.onModeration,
        createdTimestamp = it.createdTimestamp,
        updatedTimestamp = it.updatedTimestamp,
        timestamp = it.timestamp,
    )
}