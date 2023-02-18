package com.codehunters.data

data class ArticleInfo(
    val id: String,
    val userId: String,
    val posterUrl: String,
    val title: String,
    val content: String,
    val tags: List<String>,
    val createdTimestamp: Long,
    val updatedTimestamp: Long,
    val timestamp: Long,
)
