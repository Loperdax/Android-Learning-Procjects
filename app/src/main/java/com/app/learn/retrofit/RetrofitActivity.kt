package com.app.learn.retrofit

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.learn.databinding.ActivityRetrofitBinding
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class RetrofitActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRetrofitBinding

    private val adapter : MovieAdapter by lazy {
        MovieAdapter()
    }

    // creating api client
    private val api by lazy {
        ApiClient().getClient().create(ApiService::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            loadingBar.visibility = View.VISIBLE
            recycleView.visibility = View.GONE

            // calling movie api
            val call = api.getMoviesList(1)
            call.enqueue(object :  Callback<ResponseMoviesList> {
                override fun onResponse(p0: Call<ResponseMoviesList>, response: Response<ResponseMoviesList>) {
                    loadingBar.visibility = View.GONE
                    recycleView.visibility = View.VISIBLE

                    // checking response
                    if (response.isSuccessful){
                        response.body()?.let { itBody ->
                            itBody.data?.let { itData ->
                                if (itData.isNotEmpty()) {

                                    // updating list
                                    adapter.differ.submitList(itData)
                                    setupAdapter()
                                }
                            }
                        }
                    }
                }

                override fun onFailure(p0: Call<ResponseMoviesList>, p1: Throwable) {
                    loadingBar.visibility = View.GONE
                    Log.e("Api Error" , p1.message.toString())
                }

            })
        }
    }

    private fun setupAdapter(){
        binding.apply {
            recycleView.adapter = adapter
            recycleView.layoutManager = LinearLayoutManager(this@RetrofitActivity)
        }
    }

}