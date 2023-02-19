package com.codehunters.studtour.reminders

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

object NotificationUtils {

    @RequiresApi(Build.VERSION_CODES.O)
    fun showNotification(
        context: Context,
        notificationId: Int,
        channelNotificationId: String,
        channelNotificationName: String,
        title: String,
        message: String,
        @DrawableRes smallIcon: Int,
        largeIcon: Bitmap? = null
    ) {

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.createNotificationChannel(
            NotificationChannel(
                channelNotificationId,
                channelNotificationName,
                NotificationManager.IMPORTANCE_DEFAULT
            )
                .apply {
                    enableVibration(true)
                    setShowBadge(true)
                    setSound(null, null)
                }
        )
        val notification = buildNotification(
            context,
            channelNotificationId,
            title,
            message,
            smallIcon,
            largeIcon
        )
        notification.flags = notification.flags or Notification.FLAG_AUTO_CANCEL
        notificationManager.notify(notificationId, notification)
    }

    private fun buildNotification(
        context: Context,
        channelNotificationId: String,
        title: String,
        message: String,
        @DrawableRes smallIcon: Int,
        largeIcon: Bitmap?
    ): Notification = NotificationCompat.Builder(context, channelNotificationId)
        .setContentTitle(title)
        .setContentText(message)
        .setSmallIcon(smallIcon)
        .setSound(null)
        .setDefaults(Notification.DEFAULT_VIBRATE or Notification.DEFAULT_LIGHTS)
        .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
        .setVibrate(LongArray(0))
        .setPriority(NotificationCompat.PRIORITY_MAX)
        .setAutoCancel(true)
        .setLargeIcon(largeIcon)
        .build()
}