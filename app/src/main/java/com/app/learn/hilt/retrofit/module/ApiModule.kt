package com.app.learn.hilt.retrofit.module

import com.app.learn.Constants.BASE_URL
import com.app.learn.Constants.NAMED_BODY
import com.app.learn.Constants.NAMED_HEADER
import com.app.learn.Constants.NETWORK_TIMEOUT
import com.app.learn.hilt.retrofit.api.ApiServices
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideBaseUrl() = BASE_URL

    @Provides
    @Singleton
    fun provideConnectionTimeout() = NETWORK_TIMEOUT


    @Provides
    @Singleton
    fun provideGson() : Gson = GsonBuilder().create()


    @Provides
    @Singleton
    @Named(NAMED_HEADER)
    fun provideHeaderInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.HEADERS
    }

    @Provides
    @Singleton
    @Named(NAMED_BODY)
    fun provideBodyInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun provideClient(
        timeout:Long ,
        @Named(NAMED_HEADER) header: HttpLoggingInterceptor ,
        @Named(NAMED_BODY) body: HttpLoggingInterceptor) =
            OkHttpClient.Builder().apply {
                connectTimeout(timeout , TimeUnit.SECONDS)
                readTimeout(timeout , TimeUnit.SECONDS)
                writeTimeout(timeout , TimeUnit.SECONDS)
                addInterceptor(header)
                addInterceptor(body)
                retryOnConnectionFailure(true)
            }.build()

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl:String , gson: Gson , client: OkHttpClient) : ApiServices =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServices::class.java)

}