package com.app.learn.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.learn.databinding.ActivityLivedataBinding

class ActivityLiveData : AppCompatActivity() {
    private lateinit var binding: ActivityLivedataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLivedataBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}