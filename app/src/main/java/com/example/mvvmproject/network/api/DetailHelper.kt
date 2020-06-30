package com.example.mvvmproject.network.api

class DetailHelper(private val detailService: DetailService) {

    suspend fun getDetail(username: String) = detailService.getDetail(username)
}