package com.codehunters.data


data class DormitoryInfo(
    val id: String,
    val userId: String,
    val timestamp: Long,
    val details: DetailsInfo,
    val onModeration: Boolean,
    val universityId: String,
    val createdTimestamp: Long,
    val updatedTimestamp: Long,
): EntitiesData()