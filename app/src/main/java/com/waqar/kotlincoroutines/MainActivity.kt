package com.waqar.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.name
    private lateinit var counterText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterText = findViewById(R.id.counter_text)

        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }
    }

    private suspend fun printFollowers() {
        // Using Launch
        var fbFollowers = 0
        var instagramFollowers = 0
        val job1 = CoroutineScope(Dispatchers.IO).launch {
            fbFollowers = getFbFollowers()
        }

        val job2 = CoroutineScope(Dispatchers.IO).launch {
            instagramFollowers = getInstagramFollowers()
        }


        job1.join()
        job2.join()
        Log.d(TAG, "FB - $fbFollowers, Insta $instagramFollowers.toString()")
    }

    private suspend fun getFbFollowers():Int {
        delay(1000)
        return 54
    }

    private suspend fun getInstagramFollowers():Int {
        delay(1000)
        return 113
    }

}