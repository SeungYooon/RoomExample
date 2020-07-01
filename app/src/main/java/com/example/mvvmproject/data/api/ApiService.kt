package com.example.mvvmproject.data.api

import com.example.mvvmproject.data.model.GithubItem
import com.example.mvvmproject.data.model.Item
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/search/repositories")
    suspend fun getUsers(@Query("q") name: String): GithubItem

    @GET("/repos/{owner}/{repo}")
    suspend fun getRepo(@Path("owner") owner: String, @Path("repo") repo: String): Item
}