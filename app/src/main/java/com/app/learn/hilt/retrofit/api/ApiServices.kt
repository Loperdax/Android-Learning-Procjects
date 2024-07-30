package com.app.learn.hilt.retrofit.api


import com.app.learn.hilt.retrofit.model.ResponseMoviesList
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("movies")
    fun getMoviesList() : Call<ResponseMoviesList>

}