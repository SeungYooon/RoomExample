package com.example.mvvmproject.data.api

import com.example.mvvmproject.data.model.User
import io.reactivex.Single

interface UserService {
    fun getUsers(): Single<List<User>>
}