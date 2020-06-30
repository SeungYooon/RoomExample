package com.example.mvvmproject.network.api

import com.example.mvvmproject.model.Item
import com.example.mvvmproject.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/search/repositories")
    suspend fun getUsers(@Query("q") name: String): User

    @GET("/repos/{owner}/{repo}")
    suspend fun getRepo(@Path("owner") owner: String, @Path("repo") repo: String): Item
}