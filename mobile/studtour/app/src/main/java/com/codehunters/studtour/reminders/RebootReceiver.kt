package com.codehunters.studtour.reminders

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.codehunters.studtour.interactors.IReminderService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RebootReceiver : BroadcastReceiver() {

    @Inject
    lateinit var reminderService: IReminderService


    override fun onReceive(context: Context, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED) {
            reminderService.restoreReminders()
        }
    }
}