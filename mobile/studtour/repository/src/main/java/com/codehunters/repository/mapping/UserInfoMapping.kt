package com.codehunters.repository.mapping

import com.codehunters.data.UserInfo
import com.codehunters.network.data.requestAuth.UserEntity

fun UserInfo.toUserEntity() = UserEntity(
    id = id,
    username = username,
    email = email,
    userRole = userRole,
    phone = phone,
    name = name,
    lastName = lastName,
    createdTimestamp = createdTimestamp,
    updatedTimestamp = updatedTimestamp,
    timestamp = timestamp
)

fun UserEntity.toUserInfo() = UserInfo(
    id = id,
    username = username,
    userRole = userRole,
    name = name,
    lastName = lastName,
    email = email,
    phone = phone,
    createdTimestamp = createdTimestamp,
    updatedTimestamp = updatedTimestamp,
    timestamp = timestamp,

)