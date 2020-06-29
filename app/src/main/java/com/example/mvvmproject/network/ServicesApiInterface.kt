package com.example.mvvmproject.network

import retrofit2.Call
import retrofit2.http.GET

interface ServicesApiInterface {
    @GET("/api/museums/")
    fun museums(): Call<MuseumResponse>
}