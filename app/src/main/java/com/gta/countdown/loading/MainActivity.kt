package com.gta.countdown.loading

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // حدد تاريخ الإصدار
        val release = Calendar.getInstance().apply {
            set(2026, Calendar.NOVEMBER, 19, 9, 0, 0)
        }
        NotificationScheduler.scheduleRelative(this, release.timeInMillis)
    }
}
