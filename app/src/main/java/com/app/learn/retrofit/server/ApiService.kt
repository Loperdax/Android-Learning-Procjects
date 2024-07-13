package com.app.learn.retrofit.server

import com.app.learn.retrofit.requests.RequestUserRegister
import com.app.learn.retrofit.responses.ResponseMovie
import com.app.learn.retrofit.responses.ResponseMoviesByGenre
import com.app.learn.retrofit.responses.ResponseMoviesList
import com.app.learn.retrofit.responses.ResponseRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movies")
    fun getMoviesList(@Query("page") pageNumber:Int ):Call<ResponseMoviesList>

    @GET("movies/{movie_id}")
    fun getMovie(@Path("movie_id") id : Int):Call<ResponseMovie>


    @GET("genres/{genre_id}/movies")
    fun getMoviesByGenre(
        @Query("page") pageNumber: Int ,
        @Path("genre_id") id: Int)
    : Call<ResponseMoviesByGenre>

    @POST("register")
    fun registerUser(@Body data : RequestUserRegister) : Call<ResponseRegister>
}