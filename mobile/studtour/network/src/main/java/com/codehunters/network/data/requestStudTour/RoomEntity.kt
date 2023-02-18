package com.codehunters.network.data.requestStudTour

data class RoomEntity(
    val userId: String,
    val universityId: String,
    val dormitoryId: String,
    val name: String,
    val id: String,
    val timestamp: Long,
    val createdTimestamp: Long,
    val updatedTimestamp: Long,
    val onModeration: Boolean,
    val details: DetailsEntity,
)