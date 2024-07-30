package com.app.learn.viewmodel

import androidx.lifecycle.ViewModel
import com.app.learn.Utils

class MainViewModel : ViewModel() {
    var counter = 0
    val items = Utils.getSimpleItems(100)

    fun incrementCounter() {
        counter++
    }


}