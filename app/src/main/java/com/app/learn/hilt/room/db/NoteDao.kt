package com.app.learn.hilt.room.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.learn.Constants.NOTE_TABLE

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNote(note: NoteModel)
    @Query("SELECT * FROM $NOTE_TABLE")
    fun getAllNotes(): MutableList<NoteModel>
}