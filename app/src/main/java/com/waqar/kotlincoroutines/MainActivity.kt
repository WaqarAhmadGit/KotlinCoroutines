package com.waqar.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.name
    private lateinit var counterText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterText = findViewById(R.id.counter_text)

        CoroutineScope(Dispatchers.IO).launch {
            task1()
        }

        CoroutineScope(Dispatchers.IO).launch {
            task2()
        }
    }

    private suspend fun task1() {
        Log.d(TAG, "STARTING TASK 1")
        delay(1000)
        Log.d(TAG, "ENDING TASK 1")
    }

    private suspend fun task2() {
        Log.d(TAG, "STARTING TASK 2")
        delay(2000)
        Log.d(TAG, "ENDING TASK 2")
    }

}