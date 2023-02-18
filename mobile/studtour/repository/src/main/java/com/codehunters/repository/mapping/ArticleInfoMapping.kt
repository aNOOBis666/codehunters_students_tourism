package com.codehunters.repository.mapping

import com.codehunters.data.ArticleInfo
import com.codehunters.network.data.requestStudTour.ArticleEntity

fun List<ArticleEntity>.toArticleInfo() = this.map {
    ArticleInfo(
        id = it.id,
        userId = it.userId,
        posterUrl = it.posterUrl,
        title = it.title,
        content = it.content,
        tags = it.tags,
        createdTimestamp = it.createdTimestamp,
        updatedTimestamp = it.updatedTimestamp,
        timestamp = it.timestamp
    )
}
