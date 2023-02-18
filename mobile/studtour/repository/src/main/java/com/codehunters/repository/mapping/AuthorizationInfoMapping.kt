package com.codehunters.repository.mapping

import com.codehunters.data.AuthorizationInfo
import com.codehunters.network.data.requestAuth.AuthEntity

fun AuthorizationInfo.toAuthorizationEntity() = AuthEntity(
    email = email,
    password = password
)