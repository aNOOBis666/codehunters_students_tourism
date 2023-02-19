package com.codehunters.network.mapping

import com.codehunters.network.data.requestAuth.UserEntity
import com.codehunters.network.data.response.UserData

fun UserEntity.toBody() = UserData(
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

fun UserData?.toUserEntity() = UserEntity(
    id = this?.id,
    username = this?.username,
    userRole = this?.userRole,
    name = this?.name,
    lastName = this?.lastName,
    email = this?.email,
    phone = this?.phone,
    createdTimestamp = this?.createdTimestamp,
    updatedTimestamp = this?.updatedTimestamp,
    timestamp = this?.timestamp
)