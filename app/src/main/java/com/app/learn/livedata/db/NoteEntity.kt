package com.app.learn.livedata.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.learn.Constants.NOTE_TABLE2

@Entity(tableName = NOTE_TABLE2)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String = "",
    var description: String = ""
)