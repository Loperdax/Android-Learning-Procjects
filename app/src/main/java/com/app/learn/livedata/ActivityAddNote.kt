package com.app.learn.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.app.learn.databinding.ActivityAddNoteBinding
import com.app.learn.livedata.db.NoteDatabase
import com.app.learn.livedata.db.NoteEntity
import java.util.concurrent.Executors

class ActivityAddNote : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var note : NoteEntity

    private val noteDB by lazy { NoteDatabase.getDatabase(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            saveBtn.setOnClickListener{
                note = NoteEntity(0 , title.text.toString(), description.text.toString() )
                Executors.newSingleThreadExecutor().execute {
                    noteDB.noteDao().saveNote(note)
                    runOnUiThread { finish() }
                }
            }
        }
    }
}