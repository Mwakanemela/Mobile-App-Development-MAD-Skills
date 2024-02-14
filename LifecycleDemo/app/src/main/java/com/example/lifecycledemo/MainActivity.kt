package com.example.lifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Timer

class MainActivity : AppCompatActivity() {

    private lateinit var timerToast: TimerToast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerToast = TimerToast(application)
        timerToast.startTimer()
    }
}