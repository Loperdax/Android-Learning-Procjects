package com.app.learn.roomDb.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.learn.roomDb.db.UserDao
import com.app.learn.roomDb.db.UserEntity


@Database(entities = [UserEntity::class], version = 1 , exportSchema = false)
abstract class UserDatabase  : RoomDatabase() {
    abstract fun dao() : UserDao
}