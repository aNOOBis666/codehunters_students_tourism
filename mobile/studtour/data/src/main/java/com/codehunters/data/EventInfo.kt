package com.codehunters.data

data class EventInfo(
    val id: String,
    val userId: String,
    val universityId: String,
    val onModeration: Boolean,
    val createdTimestamp: Long,
    val updatedTimestamp: Long,
    val timestamp: Long,
    val details: DetailsInfo,
): EntitiesData()
