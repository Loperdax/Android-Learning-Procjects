package com.app.learn.navigation.project2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.app.learn.R
import com.app.learn.databinding.ActivityNavigation2Binding

// we working on bottomNavigation in this project

class NavigationActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityNavigation2Binding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigation2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            // setting navHost and Controller
            navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host2) as NavHostFragment
            navController = navHostFragment.navController

            bottomNav.setupWithNavController(navController)
        }
    }

    override fun onNavigateUp(): Boolean {
        return navController.navigateUp() || super.onNavigateUp()
    }


}