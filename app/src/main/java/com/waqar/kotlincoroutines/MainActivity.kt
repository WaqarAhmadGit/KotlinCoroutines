package com.waqar.kotlincoroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
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
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterText = findViewById(R.id.counter_text)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        lifecycleScope.launch {
            delay(2000)
            val intent = Intent(this@MainActivity, AnotherActivity::class.java)
            startActivity(intent)
            finish()
        }

//
//        // until coroutines are not complete runBlocking will block thread
//        runBlocking {
//           launch {
//                delay(1000)
//                Log.d(TAG, "world")
//            }
//            Log.d(TAG, "hello")
//        }
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