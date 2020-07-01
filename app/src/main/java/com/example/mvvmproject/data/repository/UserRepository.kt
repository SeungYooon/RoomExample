package com.example.mvvmproject.data.repository

import com.example.mvvmproject.data.api.UserHelper
import com.example.mvvmproject.data.model.User
import io.reactivex.Single

class UserRepository(private val userHelper: UserHelper) {

    fun getUsers(): Single<List<User>> {
        return userHelper.getUsers()
    }
}