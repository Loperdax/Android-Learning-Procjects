package com.app.learn.coroutines

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.app.learn.R
import com.app.learn.databinding.ActivityCoroutinesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout

@SuppressLint("SetTextI18n")
class CoroutinesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoroutinesBinding

    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutinesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // i don't know the best way to create a job without isActive be false
        job = Job()
        job.cancel()

        binding.apply {
            startTasks.setOnClickListener {
                text1.text = "Running Coroutine 1"
                text2.text = "Running Coroutine 2"
                runCoroutines()
            }

            startSuspend.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {

                    text3.text = "Running 2 suspend fun in Main Thread"

                    val result1 = async { runSuspend1("HI Devs") }
                    val result2 = async { runSuspend2("HI Guys") }

                    // we can wait for result and use them when ready
                    text3.text = result1.await()
                    text3.text = result2.await()

                    // also we can wait for both of them and do a job
                    Log.d(
                        "Coroutines Activity",
                        "Both results is ready:\n ${result1.await()}  ${result2.await()}"
                    )

                }
            }

            startRunBlocking.setOnClickListener {
                // it blocking main thread ⚠
                runBlocking {
                    block4sec()
                }
                startRunBlocking.text = getString(R.string.start_runBlocking)
            }


            // we can get status of lifecycle of this job
            // job.isActive
            // job.isCancelled
            // job.isCompleted

            startJob.setOnClickListener {
                if (!job.isActive) {
                    text4.text = "Creating Job"
                    job = CoroutineScope(Dispatchers.Main).launch {
                        startJob.text = "Cancel"
                        delay(1000)
                        text4.text =
                            "Job created but not completed. it will be complete after 4 seconds"
                        delay(4000)
                        text4.text = "Job completed"
                    }
                } else {
                    // cancel is not a suspend function
                    job.cancel()
                    text4.text = "job Canceled. Click to run again"
                    startJob.text = getString(R.string.start_job)
                }

            }

            startJob2.setOnClickListener{
                CoroutineScope(Dispatchers.Main).launch {
                    text4.text = "job created"
                    val newJob = CoroutineScope(Dispatchers.Main).launch {
                        delay(2000)
                    }

                    // newJob.join()
                    // we can use :
                    newJob.cancelAndJoin()
                    text4.text = "after join running"
                    delay(1000)
                    // other codes will run after job is completed in MainThread
                    text4.text = "Start Again?"
                }
            }

            startJob4.setOnClickListener{
                lifecycleScope.launch {
                    while (true) {
                        delay(1000)
                        Log.d("Coroutines Activity", "🟢 this job will stop by exit")
                    }
                }
            }

            startJob3.setOnClickListener{
                CoroutineScope(Dispatchers.Main).launch {
                    while (true) {
                        delay(1000)
                        Log.d("Coroutines Activity", "🔴 this job won't stop")
                    }
                }
            }
        }

        // we can create custom thread
        CoroutineScope(newSingleThreadContext("Our Custom Thread")).launch {
            Log.d(
                "Coroutines Activity",
                "Custom Thread Started. name: ${Thread.currentThread().name}"
            )
        }

        // we can change thread in another thread
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("Coroutines Activity", "Changing thread. 1: ${Thread.currentThread().name}")
            withContext(Dispatchers.Main) {
                Log.d("Coroutines Activity", "Changing thread. 2: ${Thread.currentThread().name}")
            }
        }

        // we can repeat coroutine
        CoroutineScope(Dispatchers.IO).launch {
            repeat(3) {
                Log.d("Coroutines Activity", "Repeating Coroutine: $it")
            }
        }


        // we can set timeout for coroutine
        CoroutineScope(Dispatchers.IO).launch {
            withTimeout(3000) {
                counter()
            }
        }


    }

    // we can run coroutines together
    private fun runCoroutines() {
        CoroutineScope(Dispatchers.IO).launch {
            delay(2000L)
            binding.text1.text = "Task 1 Done"
        }

        CoroutineScope(Dispatchers.IO).launch {
            delay(4000L)
            binding.text2.text = "Task 2 Done"
        }
    }


    private suspend fun runSuspend1(result: String): String {
        delay(2000)
        return "Result from Suspend fun 1: $result"
    }

    private suspend fun runSuspend2(result: String): String {
        delay(4000)
        return "Result from Suspend fun 2: $result"
    }

    private suspend fun block4sec() {
        delay(4000)
    }

    private suspend fun counter() {
        for (i in 1..10) {
            delay(500)
            Log.d("Coroutines Activity", "counter: $i")
        }
    }
}
