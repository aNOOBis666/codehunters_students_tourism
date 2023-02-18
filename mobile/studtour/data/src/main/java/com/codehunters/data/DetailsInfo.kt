package com.codehunters.data

data class DetailsInfo(
    val mainInfo: MainInfo? = null,
    val rules: RulesInfo? = null,
    val services: List<ServicesInfo>? = null,
    val documents: List<String>? = null
)
