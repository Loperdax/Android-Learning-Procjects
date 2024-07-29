package com.app.learn.hilt.retrofit

import androidx.appcompat.app.AppCompatActivity
import com.app.learn.databinding.ActivityHilt2Binding

class HiltRetrofitActivity : AppCompatActivity(){

    private lateinit var binding : ActivityHilt2Binding

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHilt2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}