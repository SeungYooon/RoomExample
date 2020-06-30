package com.example.mvvmproject.network.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getUsers(name: String) = apiService.getUsers(name)

    suspend fun getRepo(owner: String, repo: String) = apiService.getRepo(owner, repo)
}