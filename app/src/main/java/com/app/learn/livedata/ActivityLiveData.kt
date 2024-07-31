package com.app.learn.livedata

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.learn.R
import com.app.learn.databinding.ActivityLivedataBinding
import com.app.learn.livedata.db.NoteDatabase

class ActivityLiveData : AppCompatActivity() {
    private lateinit var binding: ActivityLivedataBinding

    private val viewModel: MainViewModel by viewModels()
    private val internetChecker: InternetChecker by lazy { InternetChecker(application) }
    private val noteAdapter by lazy { NoteAdapter() }
    private val noteDB by lazy { NoteDatabase.getDatabase(this) }


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLivedataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // we sending new value to livedata object in viewmodel
        binding.apply {

            btn1.setOnClickListener {
                viewModel.info.value = "Done"
            }

            // building an observer
            val dataObserver = Observer<String> {
                text.text = it
            }

            // connecting observer to live data object5
            viewModel.info.observe(this@ActivityLiveData, dataObserver)


            val internetObserver = Observer<Boolean> {
                if (it) {
                    internetText.text = "Internet Connection Status: 🟢"
                    img.setImageResource(R.drawable.icons8_wifi_50)
                    img.setColorFilter(ContextCompat.getColor(this@ActivityLiveData , R.color.green) , PorterDuff.Mode.MULTIPLY)
                } else {
                    internetText.text = "Internet Connection Status: 🔴"
                    img.setImageResource(R.drawable.icons8_wi_fi_disconnected_50)
                    img.setColorFilter(ContextCompat.getColor(this@ActivityLiveData , R.color.red) , PorterDuff.Mode.MULTIPLY)
                }
            }

            internetChecker.observe(this@ActivityLiveData, internetObserver)

            btnAdd.setOnClickListener{
                val intent = Intent(this@ActivityLiveData , ActivityAddNote::class.java )
                startActivity(intent)
            }

            // we should use viewLifecycleOwner in fragment
//            noteDB.noteDao().getNotes().observe(viewLifecycleOwner)

            noteDB.noteDao().getNotes().observe(this@ActivityLiveData){
                noteAdapter.differ.submitList(it)
            }

            recyclerView.apply {
                adapter = noteAdapter
                layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            }
        }
    }
}