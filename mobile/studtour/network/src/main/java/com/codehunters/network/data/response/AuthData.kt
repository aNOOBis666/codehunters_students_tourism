package com.codehunters.network.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthData(
    @SerialName("email")
    val email: String,
    @SerialName("password")
    val password: String
)
