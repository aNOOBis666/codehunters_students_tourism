package com.codehunters.network.mapping

import com.codehunters.network.data.requestAuth.AuthEntity
import com.codehunters.network.data.response.AuthData

fun AuthEntity.toBody() = AuthData(
    email = email,
    password = password
)