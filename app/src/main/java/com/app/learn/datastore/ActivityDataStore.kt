package com.app.learn.datastore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.repeatOnLifecycle
import com.app.learn.databinding.ActivityDatastoreBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ActivityDataStore : AppCompatActivity() {

    private lateinit var binding: ActivityDatastoreBinding
    private val dataStore: DataStore<Preferences> by preferencesDataStore("MyData")
    private val dataKey = stringPreferencesKey("MyKey")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatastoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            saveBtn.setOnClickListener {
                CoroutineScope(IO).launch {
                    saveText(textInput.text.toString())
                }
            }

            lifecycle.coroutineScope.launch {// This scope will be cancelled when the Lifecycle is destroyed.
                // 👇 Runs the given block in a new coroutine when this Lifecycle is at least at CREATED state
                lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
                    getText().collect { // running when something edited
                        text1.text = it
                    }
                }
            }

        }
    }

    private suspend fun saveText(text:String){
        dataStore.edit {
            it[dataKey] = text
        }
    }

    private fun getText() = dataStore.data.map {
        it[dataKey] ?: ""
    }
}