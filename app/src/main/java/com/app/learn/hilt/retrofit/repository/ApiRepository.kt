package com.app.learn.hilt.retrofit.repository

import com.app.learn.hilt.retrofit.api.ApiServices
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class ApiRepository @Inject constructor(private var api: ApiServices) {
    fun getAllMovies() = api.getMoviesList()
}