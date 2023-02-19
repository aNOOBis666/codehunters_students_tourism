package com.codehunters.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ServicesInfo(
    val id: String,
    val name: String,
    val description: String,
    val price: String,
    val isFree: Boolean,
): Parcelable
