package com.waqar.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.name
    private lateinit var counterText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterText = findViewById(R.id.counter_text)


        // until coroutines are not complete runBlocking will block thread
        runBlocking {
           launch {
                delay(1000)
                Log.d(TAG, "world")
            }
            Log.d(TAG, "hello")
        }
    }



    private suspend fun executeTask() {
        Log.d(TAG, "Before")
        // With context is of blocking nature and block coroutine to finish first
        withContext(Dispatchers.IO) {
            delay(1000)
            Log.d(TAG, "Inside")
        }
        Log.d(TAG, "After")
    }


}