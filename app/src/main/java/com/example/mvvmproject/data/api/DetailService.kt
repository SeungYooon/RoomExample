package com.example.mvvmproject.data.api

import com.example.mvvmproject.data.model.ItemDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailService {

    @GET("/users/{username}")
    suspend fun getDetail(@Path("username") username: String): ItemDetail
}