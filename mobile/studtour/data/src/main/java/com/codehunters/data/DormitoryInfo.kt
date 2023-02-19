package com.codehunters.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DormitoryInfo(
    val id: String,
    val userId: String,
    val timestamp: Long,
    val details: DetailsInfo,
    val onModeration: Boolean,
    val universityId: String,
    val createdTimestamp: Long,
    val updatedTimestamp: Long,
): EntitiesData(), Parcelable