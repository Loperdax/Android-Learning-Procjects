package com.app.learn.hilt.room.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.learn.Constants.NOTE_TABLE

@Entity(tableName = NOTE_TABLE)
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String = ""
)
