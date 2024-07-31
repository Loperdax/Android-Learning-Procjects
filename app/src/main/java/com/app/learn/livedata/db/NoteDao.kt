package com.app.learn.livedata.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.learn.Constants.NOTE_TABLE2

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNote(noteEntity: NoteEntity)


    @Query("SELECT * FROM $NOTE_TABLE2")
    fun getNotes() :  LiveData<MutableList<NoteEntity>>

}