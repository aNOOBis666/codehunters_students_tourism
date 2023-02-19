package com.codehunters.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DatesInfo(
    val from: Long,
    val to: Long,
    val isRegular: Boolean
): Parcelable
