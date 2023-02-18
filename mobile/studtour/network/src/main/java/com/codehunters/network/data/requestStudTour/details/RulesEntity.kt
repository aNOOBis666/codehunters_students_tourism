package com.codehunters.network.data.requestStudTour.details

data class RulesEntity(
    val requiredUniDocuments: String,
    val requiredStudentsDocuments: String,
    val committee: CommitteeEntity
)