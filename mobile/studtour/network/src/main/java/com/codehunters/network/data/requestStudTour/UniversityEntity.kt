package com.codehunters.network.data.requestStudTour

data class UniversityEntity(
    val id: String,
    val userId: String,
    val name: String,
    val description: String,
    val details: DetailsEntity,
    val isDebug: Boolean,
    val onModeration: Boolean,
    val createdTimestamp: Long,
    val updatedTimestamp: Long,
    val timestamp: Long,
)