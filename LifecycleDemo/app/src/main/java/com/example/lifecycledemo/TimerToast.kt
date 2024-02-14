package com.example.lifecycledemo

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class TimerToast(application: Application, lifecycleOwner: LifecycleOwner) : LifecycleObserver {

    private var started = false
    private val lifecycle = lifecycleOwner.lifecycle

    init {
        lifecycle.addObserver(this)
    }
    //for each 60s the timer will run and get a toast for each 3s interval
    private val timer: CountDownTimer = object: CountDownTimer(60000, 3000) {
        override fun onTick(milliSecondsUntilFinished: Long) {
            if(lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                Toast.makeText(application, "$milliSecondsUntilFinished", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFinish() {
            //run toast on ui thread
            if(lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                Toast.makeText(application, "Finished", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startTimer() {
        if(!started) {
            started = true
            timer.start()
        }
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopTimer() {
        timer.cancel()
    }
}