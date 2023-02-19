package com.codehunters.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info(
    val name: String,
    val position: String,
    val phone: String,
    val email: String
): Parcelable
