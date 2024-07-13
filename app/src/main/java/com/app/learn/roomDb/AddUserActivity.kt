package com.app.learn.roomDb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.app.learn.Constants.DATABASE_NAME
import com.app.learn.databinding.ActivityAddUserBinding
import com.app.learn.roomDb.db.UserDatabase
import com.app.learn.roomDb.db.UserEntity
import com.google.android.material.snackbar.Snackbar

class AddUserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddUserBinding

    // Building database Connector
    private val userDb : UserDatabase by lazy {
        Room.databaseBuilder(this , UserDatabase::class.java , DATABASE_NAME)
            // running queries on ui or main thread
            .allowMainThreadQueries()
            // migrate to avoid of conflict
            .fallbackToDestructiveMigration()
            .build()
    }

    private lateinit var user: UserEntity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            SaveButton.setOnClickListener(){
                val name = NameEdit.text.toString()
                val age = AgeEdit.text.toString()

                if (name.isNotEmpty() || age.isNotEmpty()) {
                    // creating an object
                    user = UserEntity(0 , name , age.toInt())

                    // using db and dao and func for query
                    userDb.dao().saveUser(user)
                    finish()
                } else {
                    Snackbar.make(it , "Name And Age Cannot be Empty" , Snackbar.LENGTH_SHORT).show()
                }


            }
        }

    }
}