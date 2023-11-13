package com.example.startingservices

import android.app.IntentService
import android.content.Intent
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerService : IntentService("TimerService") {

    override fun onHandleIntent(intent: Intent?) {
        val startValue = intent?.getIntExtra("startValue", 0) ?: 0
        startCountdown(startValue)
    }

    private fun startCountdown(startValue: Int) {
        GlobalScope.launch(Dispatchers.Default) {
            for (i in startValue downTo 1) {
                Log.d("Countdown", "Countdown: $i")
                delay(1000)
            }
            stopSelf()
        }
    }
}
