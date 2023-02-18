package com.codehunters.network.data.requestStudTour

data class EventEntity(
    val id: String,
    val userId: String,
    val universityId: String,
    val onModeration: Boolean,
    val createdTimestamp: Long,
    val updatedTimestamp: Long,
    val timestamp: Long,
    val details: DetailsEntity,
)
