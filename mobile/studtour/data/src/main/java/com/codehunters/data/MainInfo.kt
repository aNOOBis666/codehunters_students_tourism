package com.codehunters.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MainInfo(
    val name: String,
    val shortName: String,
    val founderName: String,
    val adminContacts: String,
    val photoUrl: String,
    val site: String,
    val committee: CommitteeInfo,
    val city: String,
    val region: String,
    val district: String,
    val street: String,
    val houseNumber: String,
    val coordinates: CoordinatesInfo,
    val minDays: String,
    val maxDays: String,
    val photoUrls: List<String>,
    val mealPlan: String,
    val dates: DatesInfo,
    val link: String,
    val videos: List<String>,
    val woS: String,
    val owner: Info,
    val unit: Info,
    val admin: Info,
    val establishmentYear: String,
    val contactsName: String,
    val phone: String,
    val email: String,

    val isFree: Boolean,
    val type: String,
    val description: String,
    val amount: String,
    val price: String,
): Parcelable
