package com.codehunters.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CommitteeInfo(
    val email: String,
    val phone: String,
    val name: String
): Parcelable
