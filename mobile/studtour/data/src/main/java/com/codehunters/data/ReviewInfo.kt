package com.codehunters.data

data class ReviewInfo(
    val id: String,
    val userId: String,
    val universityId: String,
    val dormitoryId: String,
    val eventId: String,
    val photos: List<String>,
    val topic: String,
    val text: String,
    val rating: Int,
    val published: Boolean,
    val onModeration: Boolean,
    val createdTimestamp: Long,
    val updatedTimestamp: Long,
    val timestamp: Long,
): EntitiesData()