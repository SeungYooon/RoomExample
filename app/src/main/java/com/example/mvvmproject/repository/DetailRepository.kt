package com.example.mvvmproject.repository

import com.example.mvvmproject.network.api.DetailHelper

class DetailRepository(private val detailHelper: DetailHelper) {

    suspend fun getDetail(username: String) = detailHelper.getDetail(username)
}