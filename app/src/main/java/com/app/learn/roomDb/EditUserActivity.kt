package com.app.learn.roomDb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.app.learn.Constants.DATABASE_NAME
import com.app.learn.Constants.ID_EXTRA
import com.app.learn.databinding.ActivityEditUserBinding
import com.app.learn.roomDb.db.UserDatabase
import com.app.learn.roomDb.db.UserEntity
import com.google.android.material.snackbar.Snackbar

class EditUserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEditUserBinding
    private lateinit var user : UserEntity

    // init db
    private val userDb by lazy {
        Room.databaseBuilder(this , UserDatabase::class.java , DATABASE_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let {
            // getting name from extra
            val name = it.getString(ID_EXTRA).toString()
            // setting user by given name
            user = userDb.dao().getUserByName(name)
        }

        binding.apply {
            NameEdit.setText(user.name)
            AgeEdit.setText(user.age.toString())


            DeleteButton.setOnClickListener{
                // delete user and finish activity
                userDb.dao().deleteUser(user)
                finish()
            }

            SaveButton.setOnClickListener{
                if (NameEdit.text.isNotEmpty() && AgeEdit.text.isNotEmpty()){
                    // updating user by same id of given user and new data
                    userDb.dao().updateUser(UserEntity(user.id ,  NameEdit.text.toString() , AgeEdit.text.toString().toInt() ))
                    finish()
                } else {
                    Snackbar.make(it , "Name Or Age Cannot be Empty" , Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
}