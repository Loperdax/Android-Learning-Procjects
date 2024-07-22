package com.app.learn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.learn.coroutines.CoroutinesActivity
import com.app.learn.databinding.ActivityMainBinding
import com.app.learn.navigation.project1.NavigationActivity
import com.app.learn.navigation.project2.NavigationActivity2
import com.app.learn.recycle.UserListActivity
import com.app.learn.retrofit.RetrofitActivity
import com.app.learn.roomDb.RoomActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            RecycleButton.setOnClickListener{
                val intent = Intent(this@MainActivity , UserListActivity::class.java)
                startActivity(intent)
            }
            RoomDb.setOnClickListener{
                val intent = Intent(this@MainActivity , RoomActivity::class.java)
                startActivity(intent)
            }
            Retrofit.setOnClickListener{
                val intent = Intent(this@MainActivity , RetrofitActivity::class.java)
                startActivity(intent)
            }
            NavigationComponents.setOnClickListener{
                val intent = Intent(this@MainActivity , NavigationActivity::class.java)
                startActivity(intent)
            }
            NavigationComponents2.setOnClickListener{
                val intent = Intent(this@MainActivity , NavigationActivity2::class.java)
                startActivity(intent)
            }
            Coroutines.setOnClickListener {
                val intent = Intent(this@MainActivity, CoroutinesActivity::class.java)
                startActivity(intent)
            }
        }




    }

}
