package com.app.learn.hilt.room.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteModel::class], version = 1 , exportSchema = false)
abstract class NoteDB : RoomDatabase() {
    abstract fun noteDao() : NoteDao
}