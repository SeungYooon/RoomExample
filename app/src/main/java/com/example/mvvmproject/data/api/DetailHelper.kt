package com.example.mvvmproject.data.api

class DetailHelper(private val detailService: DetailService) {

    suspend fun getDetail(username: String) = detailService.getDetail(username)
}