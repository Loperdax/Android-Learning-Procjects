package com.app.learn.retrofit.requests

import com.google.gson.annotations.SerializedName

data class RequestUserRegister(
    @SerializedName("email")
    val email : String? ,
    @SerializedName("password")
    val password : String? ,
    @SerializedName("name")
    val name : String?
)
