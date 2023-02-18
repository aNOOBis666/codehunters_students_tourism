package com.codehunters.studtour.interactors

import com.codehunters.data.DormitoryInfo
import com.codehunters.data.EntitiesData
import com.codehunters.data.LabInfo

fun List<DormitoryInfo>.search(query: String): List<EntitiesData> {
    if (query.isEmpty()) return this

    val regexQuery = ".*(${query}).*".toRegex(RegexOption.IGNORE_CASE)

    return filter {
        (it.details.mainInfo?.name ?: it.details.mainInfo?.shortName)
            ?.lowercase()
            ?.isMatchRegex(regexQuery)
            ?: false
    }
}

fun List<LabInfo>.searchQuery(query: String): List<EntitiesData> {
    if (query.isEmpty()) return this

    val regexQuery = ".*(${query}).*".toRegex(RegexOption.IGNORE_CASE)

    return filter {
        (it.details.mainInfo?.name ?: it.details.mainInfo?.shortName)
            ?.lowercase()
            ?.isMatchRegex(regexQuery)
            ?: false
    }
}

private fun String.isMatchRegex(regex: Regex) = isNotEmpty() && regex.containsMatchIn(this)