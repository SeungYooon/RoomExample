package com.example.mvvmproject.data.api

class UserHelper(private val userService: UserService) {

    fun getUsers() = userService.getUsers()
}