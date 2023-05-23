package com.waqar.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
   lateinit var counterText :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterText = findViewById(R.id.counter_text)
    }

    fun updateCounter(view:View){
        counterText.text = "${counterText.text.toString().toInt()+1}"
    }

    private fun executeLonRunningTask(){
        for (i in 1..10000000000L){

        }
    }

    fun doAction(view: View) {
        thread(start = true) {
            executeLonRunningTask()
        }
    }
}