package com.codehunters.data

data class UniversityInfo(
    val id: String,
    val userId: String,
    val name: String,
    val description: String,
    val details: DetailsInfo,
    val isDebug: Boolean,
    val onModeration: Boolean,
    val createdTimestamp: Long,
    val updatedTimestamp: Long,
    val timestamp: Long,
): EntitiesData()