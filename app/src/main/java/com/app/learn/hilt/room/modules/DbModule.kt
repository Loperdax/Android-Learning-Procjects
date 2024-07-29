package com.app.learn.hilt.room.modules

import android.content.Context
import androidx.room.Room
import com.app.learn.Constants.NOTE_DATABASE
import com.app.learn.hilt.room.db.NoteDB
import com.app.learn.hilt.room.db.NoteModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Singleton
    @Provides
    fun provideNoteDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(context , NoteDB::class.java , NOTE_DATABASE)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()


    @Singleton
    @Provides
    fun provideDao(noteDB: NoteDB) = noteDB.noteDao()

    @Singleton
    @Provides
    fun provideModel() = NoteModel()


}