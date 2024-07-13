package com.app.learn.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movies")
    fun getMoviesList(@Query("page") pageNumber:Int ):Call<ResponseMoviesList>




}