package com.codehunters.network

import retrofit2.Response

val UNAUTHORIZED = 401

fun <T> Response<T>.requestStatus(): T? {
    return when {
        isSuccessful -> body()
        code() == UNAUTHORIZED -> null
        else -> throw InternetException(code().toString(), Throwable(message()))
    }
}