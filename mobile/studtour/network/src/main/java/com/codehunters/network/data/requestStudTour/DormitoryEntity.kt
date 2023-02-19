package com.codehunters.network.data.requestStudTour


data class DormitoryEntity(
    val id: String,
    val userId: String,
    val timestamp: Long,
    val details: DetailsEntity,
    val onModeration: Boolean,
    val universityId: String,
    val createdTimestamp: Long,
    val updatedTimestamp: Long,
)