package com.codehunters.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailsInfo(
    val mainInfo: MainInfo? = null,
    val rules: RulesInfo? = null,
    val services: List<ServicesInfo>? = null,
    val documents: List<String>? = null
): Parcelable
