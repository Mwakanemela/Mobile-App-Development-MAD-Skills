package com.example.lifecycledemo

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast

class TimerToast(application: Application) {
    //for each 60s the timer will run and get a toast for each 3s interval
    private val timer: CountDownTimer = object: CountDownTimer(6000, 3000) {
        override fun onTick(milliSecondsUntilFinished: Long) {
            Toast.makeText(application, "$milliSecondsUntilFinished", Toast.LENGTH_SHORT).show()
        }

        override fun onFinish() {
            Toast.makeText(application, "Finished", Toast.LENGTH_SHORT).show()
        }
    }

    fun startTimer() {
        timer.start()
    }

    fun stopTimer() {
        timer.cancel()
    }
}