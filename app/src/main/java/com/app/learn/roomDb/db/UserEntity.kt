package com.app.learn.roomDb.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.learn.Constants.TABLE_NAME



// Creating Model
@Entity(tableName = TABLE_NAME)
data class UserEntity(

    // setting PK
    // adding AutoGenerate to set automatic id
    @PrimaryKey(autoGenerate = true)
    val id : Int ,

    // we can change column name
    @ColumnInfo(name = "user_name")
    val name : String ,

    val age : Int
)
