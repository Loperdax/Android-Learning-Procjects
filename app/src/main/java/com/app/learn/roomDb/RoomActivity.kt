package com.app.learn.roomDb

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.app.learn.Constants
import com.app.learn.databinding.ActivtyRoomBinding
import com.app.learn.roomDb.db.UserDatabase

class RoomActivity : AppCompatActivity() {

    private lateinit var binding: ActivtyRoomBinding


    private val userAdapter : UserAdapter by lazy {
        UserAdapter()
    }

    // Building database Connector
    private val userDb : UserDatabase by lazy {
        Room.databaseBuilder(this , UserDatabase::class.java , Constants.DATABASE_NAME)
            // running queries on ui or main thread
            .allowMainThreadQueries()
            // migrate to avoid of conflict
            .fallbackToDestructiveMigration()
            .build()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivtyRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            addUserButton.setOnClickListener {
                val intent = Intent(this@RoomActivity , AddUserActivity::class.java)
                startActivity(intent)
            }
        }

    }

    override fun onResume() {
        super.onResume()
        checkItems()
    }

    private fun checkItems(){
        binding.apply {
            if (userDb.dao().getAllUsers().isNotEmpty()){
                // showing recycler and hiding text
                RecycleViewVi.visibility = View.VISIBLE
                EmptyListTextView.visibility = View.GONE

                // updating differ list
                userAdapter.differ.submitList(userDb.dao().getAllUsers())
                setupRecyclerView()


            } else {
                // showing text and hiding recycler
                RecycleViewVi.visibility = View.GONE
                EmptyListTextView.visibility = View.VISIBLE
            }

        }

    }


    private fun setupRecyclerView(){
        binding.RecycleViewVi.apply{
            layoutManager = LinearLayoutManager(this@RoomActivity)
            adapter = userAdapter
        }
    }
}