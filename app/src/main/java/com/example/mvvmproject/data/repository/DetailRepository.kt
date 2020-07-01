package com.example.mvvmproject.data.repository

import com.example.mvvmproject.data.api.DetailHelper

class DetailRepository(private val detailHelper: DetailHelper) {

    suspend fun getDetail(username: String) = detailHelper.getDetail(username)
}