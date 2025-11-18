package com.gta.countdown.loading

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

object NotificationScheduler {
    fun scheduleRelative(ctx: Context, releaseMillis: Long) {
        val am = ctx.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val times = arrayOf(
            releaseMillis - 7L * 24 * 3600 * 1000, // أسبوع قبل
            releaseMillis - 1L * 24 * 3600 * 1000, // يوم قبل
            releaseMillis // وقت الإصدار
        )

        for ((i, t) in times.withIndex()) {
            if (t <= System.currentTimeMillis()) continue
            val intent = Intent(ctx, AlarmReceiver::class.java).apply {
                putExtra("msg", when(i) {
                    0 -> "تبقّى أسبوع واحد على صدور GTA VI"
                    1 -> "تبقّى يوم واحد على صدور GTA VI"
                    else -> "صدرت GTA VI الآن! تحقق منها"
                })
            }
            val pi = PendingIntent.getBroadcast(ctx, 1000 + i, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
            am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, t, pi)
        }
    }
}
