package com.app.learn.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val info: MutableLiveData<String> by lazy { MutableLiveData<String>() }
}