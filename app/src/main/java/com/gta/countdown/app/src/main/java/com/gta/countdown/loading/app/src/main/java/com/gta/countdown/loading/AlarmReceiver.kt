package com.gta.countdown.loading

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val msg = intent.getStringExtra("msg") ?: "GTA VI Update"
        val channelId = "gta_countdown_channel"

        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("GTA Countdown")
            .setContentText(msg)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        val nm = NotificationManagerCompat.from(context)
        nm.notify((System.currentTimeMillis() % 10000).toInt(), builder.build())
    }
}
