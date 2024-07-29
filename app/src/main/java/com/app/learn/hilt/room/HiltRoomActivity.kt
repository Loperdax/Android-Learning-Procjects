package com.app.learn.hilt.room

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.learn.databinding.ActivityHiltBinding
import com.app.learn.hilt.room.db.NoteModel
import com.app.learn.hilt.room.repository.DbRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HiltRoomActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHiltBinding

    @Inject
    lateinit var repository: DbRepository

    @Inject
    lateinit var adapter: NoteAdapter

    @Inject
    lateinit var noteModel: NoteModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHiltBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            saveNote.setOnClickListener{
                noteModel.id = 0 // cuz its auto generated
                noteModel.title = textInput.text.toString()
                repository.saveNote(noteModel)
                textInput.setText("")
                adapter.differ.submitList(repository.getAllNotes())
            }

            adapter.differ.submitList(repository.getAllNotes())
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this@HiltRoomActivity)

            // click on item
            adapter.setOnItemClickListener {
                Toast.makeText(this@HiltRoomActivity, it.title, Toast.LENGTH_SHORT).show()
            }
        }
    }
}