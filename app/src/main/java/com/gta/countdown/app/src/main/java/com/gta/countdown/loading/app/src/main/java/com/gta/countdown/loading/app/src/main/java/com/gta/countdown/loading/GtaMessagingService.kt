package com.gta.countdown.loading

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class GtaMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val body = remoteMessage.notification?.body ?: remoteMessage.data["body"] ?: "GTA Update"
        val builder = NotificationCompat.Builder(this, "gta_countdown_channel")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("GTA Countdown (Server)")
            .setContentText(body)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
        NotificationManagerCompat.from(this).notify((System.currentTimeMillis() % 10000).toInt(), builder.build())
    }
}
