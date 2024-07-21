package com.app.learn.navigation.project1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.app.learn.R
import com.app.learn.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {

    //------- created this activity just for Separation of training topics ------//

    private lateinit var binding : ActivityNavigationBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // we should create a navHost first by adding a navHost view in this activity layout
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            // setting navHost and Controller
            navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
            navController = navHostFragment.navController

            // setting app bar and connecting to navController
            setSupportActionBar(toolbar)
            appBarConfiguration = AppBarConfiguration.Builder(setOf(R.id.homeFragment , R.id.detailFragment))
                .build()
            setupActionBarWithNavController(navController , appBarConfiguration)


        }
    }

    // should add this func
    override fun onNavigateUp(): Boolean {
        return navController.navigateUp() || super.onNavigateUp()
    }



}