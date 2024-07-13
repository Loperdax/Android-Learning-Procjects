package com.app.learn.roomDb.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.app.learn.Constants.TABLE_NAME

@Dao
interface UserDao {

    // adding queries to have connection with db

    // save a row
    // we can add onConflict -> Replace : Replace with old data     Ignore : do nothing      abort : don't add
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(user: UserEntity)

    // update a data
    @Update
    fun updateUser(user: UserEntity)

    // delete a data
    @Delete
    fun deleteUser(user: UserEntity)


    // custom Queries
    @Query("SELECT * FROM $TABLE_NAME ORDER BY id DESC")
    fun getAllUsers(): MutableList<UserEntity>

    @Query("SELECT * FROM $TABLE_NAME WHERE user_name LIKE:userName")
    fun getUserByName(userName: String): UserEntity

    @Query("DELETE FROM $TABLE_NAME")
    fun deleteAllUsers()

}