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
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.name
    private lateinit var counterText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterText = findViewById(R.id.counter_text)

        GlobalScope.launch {
            executeTask()
        }
    }

    private suspend fun executeLonRunningTask(){
    for(i in 1..10000000){

    }
    }

    private suspend fun executeTask() {


val parentJob = CoroutineScope(Dispatchers.IO).launch {
    for (i in 1..1000){
        if (this.isActive) {
            executeLonRunningTask()
            Log.d(TAG, i.toString())
        }
    }
}

        delay(100)
        Log.d(TAG, "Cancelling Job")
        parentJob.cancel()
        parentJob.join()
        Log.d(TAG, "Parent completed")



//        val parentJob = GlobalScope.launch(Dispatchers.Main) {
//            Log.d(TAG, "Parent Started")
//
//            val childJob = launch {
//                try {
//                    Log.d(TAG, "Child Started")
//                    delay(5000)
//                    Log.d(TAG, "Child Ended")
//                }catch (e:CancellationException){
//                    Log.d(TAG, "Child Canceled")
//                }
//            }
//
//            delay(3000)
//            childJob.cancel()
//            Log.d(TAG, "Parent Ended")
//        }

//        delay(1000)

        // Parent job cancel will cancel child jobs
//        parentJob.cancel()

        // Parent job delayed until all child jobs completed
//        parentJob.join()
//        Log.d(TAG, "Parent Completed")

//        Log.d(TAG, "before")
//        withContext(Dispatchers.IO) {
//            delay(1000)
//            Log.d(TAG, "inside")
//        }
//        Log.d(TAG, "After")
    }

//    private suspend fun printFollowers() {
//        // Using Launch
//        var fbFollowers = 0
//        var instagramFollowers = 0
//        val job1 = CoroutineScope(Dispatchers.IO).launch {
//            fbFollowers = getFbFollowers()
//        }
//
//        val job2 = CoroutineScope(Dispatchers.IO).launch {
//            instagramFollowers = getInstagramFollowers()
//        }
//
//        job1.join()
//        job2.join()
//        Log.d(TAG, "FB - $fbFollowers, Insta $instagramFollowers.toString()")

        // Using Async
//        val fb = CoroutineScope(Dispatchers.IO).async {
//            getFbFollowers()
//        }
//
//        val instagram = CoroutineScope(Dispatchers.IO).async {
//             getInstagramFollowers()
//        }
//
//        Log.d(TAG, "FB - ${fb.await()}, Instagram ${instagram.await()}.toString()")
//
//        // Another way to do it
//        CoroutineScope(Dispatchers.IO).launch {
//            val fb = async { getFbFollowers() }
//            val instagram = async { getInstagramFollowers() }
//            Log.d(TAG, "FB - ${fb.await()}, Instagram ${instagram.await()}.toString()")
//        }
//
//    }
//
//    private suspend fun getFbFollowers():Int {
//        delay(1000)
//        return 54
//    }
//
//    private suspend fun getInstagramFollowers():Int {
//        delay(1000)
//        return 113
//    }

}