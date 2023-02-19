package com.codehunters.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RulesInfo(
    val requiredUniDocuments: String,
    val requiredStudentsDocuments: String,
    val committee: CommitteeInfo
): Parcelable