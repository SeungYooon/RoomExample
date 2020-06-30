package com.example.mvvmproject.network.api

import com.example.mvvmproject.model.UserDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailService {

    @GET("/users/{username}")
    suspend fun getDetail(@Path("username") username: String): UserDetail
}