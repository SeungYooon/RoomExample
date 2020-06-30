package com.example.mvvmproject.repository

import com.example.mvvmproject.network.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers(name: String) = apiHelper.getUsers(name)

    suspend fun getRepo(owner: String, repo: String) = apiHelper.getRepo(owner, repo)
}