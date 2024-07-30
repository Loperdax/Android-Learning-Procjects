package com.app.learn.hilt.retrofit.api

import com.app.learn.Constants.BASE_URL
import com.app.learn.Constants.NETWORK_TIMEOUT
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    private lateinit var retrofit : Retrofit

    private val client = OkHttpClient.Builder()
        .connectTimeout(NETWORK_TIMEOUT , TimeUnit.SECONDS)
        .readTimeout(NETWORK_TIMEOUT , TimeUnit.SECONDS)
        .writeTimeout(NETWORK_TIMEOUT , TimeUnit.SECONDS)
        .build()


    fun getClient(): Retrofit {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit
    }
}