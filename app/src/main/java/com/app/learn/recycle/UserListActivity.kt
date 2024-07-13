package com.app.learn.recycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.learn.databinding.ActivityUserListBinding

class UserListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserListBinding


    // define adapter with differ as lazy for better performance
    private val userListAdapter by lazy { UserAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // sending list to differ of our adapter
        userListAdapter.differ.submitList(loadData())

        // setting recycler view and adapter
        binding.recycle.apply {
            layoutManager = LinearLayoutManager(this@UserListActivity)
            adapter = userListAdapter
        }

//        binding.recycle.layoutManager = LinearLayoutManager(this)
//        binding.recycle.adapter = UserAdapter(loadData())
    }

    private fun loadData(): MutableList<UsersModel> {
        val data: MutableList<UsersModel> = mutableListOf()
        data.add(UsersModel(1, "Amir", 12))
        data.add(UsersModel(2, "Khalil", 35))
        data.add(UsersModel(3, "Karim", 2))
        data.add(UsersModel(4, "Rahim", 56))
        data.add(UsersModel(5, "Jalil", 25))
        return data
    }
}