package com.codehunters.network.mapping

import com.codehunters.network.data.requestStudTour.ArticleEntity
import com.codehunters.network.data.response.ResponseData

fun List<ResponseData>?.toArticles() = this?.map {
    ArticleEntity(
        id = it.id.orEmpty(),
        userId = it.userId.orEmpty(),
        posterUrl = it.posterUrl.orEmpty(),
        title = it.title.orEmpty(),
        content = it.content.orEmpty(),
        tags = it.tags ?: emptyList(),
        createdTimestamp = it.createdTimestamp ?: 0L,
        updatedTimestamp = it.updatedTimestamp ?: 0L,
        timestamp = it.timestamp ?: 0L
    )
} ?: emptyList()