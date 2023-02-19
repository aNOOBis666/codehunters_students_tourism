package com.codehunters.studtour.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun convertTimeToFormat(
    time: Long,
    pattern: String = "yyyy-MM-dd",
    ignoreTimeZone: Boolean = false,
    isMillis: Boolean = true
): String {
    val formatter = DateTimeFormatter.ofPattern(pattern)
    return formatter.format(time.toDateTime(isMillis, ignoreTimeZone))
}

@RequiresApi(Build.VERSION_CODES.O)
fun Long.toDateTime(isMillis: Boolean, ignoreTimeZone: Boolean = false): LocalDateTime {
    return LocalDateTime.ofInstant(
        isMillis.then(
            { Instant.ofEpochMilli(this) },
            { Instant.ofEpochSecond(this) }),
        ignoreTimeZone.then(
            { java.time.ZoneOffset.ofHours(0) },
            { ZoneId.systemDefault() })
    )
}

fun <T> Boolean.then(yes: () -> T, no: () -> T): T =
    if (this) yes.invoke() else no.invoke()
