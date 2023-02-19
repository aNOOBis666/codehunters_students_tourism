package com.codehunters.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoordinatesInfo(
    val latitude: Float,
    val longitude: Float
): Parcelable
