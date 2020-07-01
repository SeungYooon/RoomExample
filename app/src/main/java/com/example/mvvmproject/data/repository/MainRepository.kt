package com.example.mvvmproject.data.repository

import com.example.mvvmproject.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers(name: String) = apiHelper.getUsers(name)

    suspend fun getRepo(owner: String, repo: String) = apiHelper.getRepo(owner, repo)
}