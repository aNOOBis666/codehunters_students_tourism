package com.codehunters.network.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserData (
    @SerialName("id")
    val id: String? = null,
    @SerialName("username")
    val username: String? = null,
    @SerialName("email")
    val email: String? = null,
    @SerialName("userRole")
    val userRole: String? = null,
    @SerialName("phone")
    val phone: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("lastName")
    val lastName: String? = null,
    @SerialName("createdTimestamp")
    val createdTimestamp: Long? = null,
    @SerialName("updatedTimestamp")
    val updatedTimestamp: Long? = null,
    @SerialName("timestamp")
    val timestamp: Long? = null,
)