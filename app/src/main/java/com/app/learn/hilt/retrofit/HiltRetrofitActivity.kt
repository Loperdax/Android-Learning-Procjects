package com.app.learn.hilt.retrofit

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.learn.databinding.ActivityHilt2Binding
import com.app.learn.hilt.retrofit.model.ResponseMoviesList
import com.app.learn.hilt.retrofit.repository.ApiRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@AndroidEntryPoint
class HiltRetrofitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHilt2Binding

    @Inject
    lateinit var adapter: MovieAdapter

    @Inject
    lateinit var repository: ApiRepository

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHilt2Binding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.apply {

            loading()

            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this@HiltRetrofitActivity)

            repository.getAllMovies().enqueue(object : Callback<ResponseMoviesList>{
                override fun onResponse(p0: Call<ResponseMoviesList>, p1: Response<ResponseMoviesList>) {
                    loaded()
                    p1.body()?.let {
                        it.data?.let { data ->
                            adapter.differ.submitList(data)
                        }
                    }
                }

                override fun onFailure(p0: Call<ResponseMoviesList>, p1: Throwable) {
                    loaded()
                    Toast.makeText(this@HiltRetrofitActivity, p1.message, Toast.LENGTH_SHORT).show()
                }

            })

//            adapter.differ.submitList()
        }
    }

    private fun loading() {
        binding.recyclerView.visibility = View.GONE
        binding.moviesLoading.visibility = View.VISIBLE
    }

    private fun loaded() {
        binding.recyclerView.visibility = View.VISIBLE
        binding.moviesLoading.visibility = View.GONE
    }
}