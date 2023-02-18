package com.codehunters.network.data.requestStudTour

import com.codehunters.network.data.requestStudTour.details.MainInfoEntity
import com.codehunters.network.data.requestStudTour.details.RulesEntity
import com.codehunters.network.data.requestStudTour.details.ServicesEntity

data class DetailsEntity(
    val mainInfo: MainInfoEntity? = null,
    val rules: RulesEntity? = null,
    val services: List<ServicesEntity>? = null,
    val documents: List<String>? = null
)
