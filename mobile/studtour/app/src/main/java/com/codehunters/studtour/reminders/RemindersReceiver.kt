package com.codehunters.studtour.reminders

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavDeepLinkBuilder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.codehunters.data.Reminder
import com.codehunters.studtour.R
import com.codehunters.studtour.interactors.IReminderService
import com.codehunters.studtour.reminders.NotificationUtils.showNotification
import com.codehunters.studtour.utils.convertTimeToFormat
import com.codehunters.studtour.utils.dpFromPx
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RemindersReceiver : BroadcastReceiver() {
    companion object {
        private const val DEFAULT_INT = 0
        private const val DEFAULT_LONG = 0L
        const val ID = "CODEHUNTERS-EVENT-ID"
        const val BOOKING_ID = "CODEHUNTERS-EVENT-BOOKING-ID"
        const val START_TIME = "CODEHUNTERS-EVENT-START-TIME"
        const val DORMITORY_POSTER_URL = "DORMITORY-EVENT-POSTER-URL"
        const val DORMITORY_NAME = "DORMITORY-EVENT-NAME"
    }

    @Inject
    lateinit var reminderService: IReminderService

    private val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    override fun onReceive(context: Context, intent: Intent?) {
        val id = intent?.getIntExtra(ID, DEFAULT_INT)
        val bookingId = intent?.getStringExtra(BOOKING_ID).orEmpty()
        val startTime = intent?.getLongExtra(START_TIME, DEFAULT_LONG)
        val dormitoryPosterUrl = intent?.getStringExtra(DORMITORY_POSTER_URL).orEmpty()
        val dormitoryName = intent?.getStringExtra(DORMITORY_NAME).orEmpty()

        scope.launch {
            Glide.with(context)
                .asBitmap()
                .load(dormitoryPosterUrl)
                .transform(
                    RoundedCorners(
                        dpFromPx(
                            context,
                            context.resources.getDimension(R.dimen.corner_radius)
                        ).toInt()
                    )
                )
                .into(
                    object : CustomTarget<Bitmap>() {
                        @RequiresApi(Build.VERSION_CODES.O)
                        override fun onResourceReady(
                            largeIcon: Bitmap,
                            transition: Transition<in Bitmap>?
                        ) {
                            showNotification(
                                context,
                                id ?: DEFAULT_INT,
                                bookingId,
                                context.getString(R.string.reminder_title),
                                dormitoryName,
                                convertTimeToFormat(startTime ?: DEFAULT_LONG),
                                R.mipmap.ic_launcher,
                                largeIcon
                            )
                        }

                        @RequiresApi(Build.VERSION_CODES.O)
                        override fun onLoadFailed(placeholder: Drawable?) {
                            showNotification(
                                context,
                                id ?: DEFAULT_INT,
                                bookingId,
                                context.getString(R.string.reminder_title),
                                dormitoryName,
                                convertTimeToFormat(startTime ?: DEFAULT_LONG),
                                R.mipmap.ic_launcher
                            )
                        }

                        override fun onLoadCleared(placeholder: Drawable?) {}
                    }
                )
            reminderService.deleteReminder(Reminder(
                id = id ?: DEFAULT_INT,
                bookingId = bookingId,
                startTime = startTime ?: DEFAULT_LONG,
                dormitoryPosterUrl = dormitoryPosterUrl,
                dormitoryName = dormitoryName
            ))
        }
    }
}