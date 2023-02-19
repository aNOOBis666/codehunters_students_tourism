package com.codehunters.network.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseToken(
    @SerialName("token")
    val token: String? = null
)