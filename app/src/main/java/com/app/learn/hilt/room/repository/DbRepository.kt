package com.app.learn.hilt.room.repository

import com.app.learn.hilt.room.db.NoteDao
import com.app.learn.hilt.room.db.NoteModel
import javax.inject.Inject

class DbRepository @Inject constructor(private val dao: NoteDao) {

    fun saveNote(model: NoteModel) = dao.saveNote(model)
    fun getAllNotes() = dao.getAllNotes()
}