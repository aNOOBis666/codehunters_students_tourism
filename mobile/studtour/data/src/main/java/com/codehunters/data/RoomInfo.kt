package com.codehunters.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RoomInfo(
    val userId: String,
    val universityId: String,
    val dormitoryId: String,
    val name: String,
    val id: String,
    val timestamp: Long,
    val createdTimestamp: Long,
    val updatedTimestamp: Long,
    val onModeration: Boolean,
    val details: DetailsInfo,
): EntitiesData(), Parcelable