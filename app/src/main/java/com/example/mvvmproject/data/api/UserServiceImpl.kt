package com.example.mvvmproject.data.api

import com.example.mvvmproject.data.model.User
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class UserServiceImpl : UserService {

    private val BASE_URl = "https://5e510330f2c0d300147c034c.mockapi.io/users"

    override fun getUsers(): Single<List<User>> {
        return Rx2AndroidNetworking.get(BASE_URl)
            .build()
            .getObjectListSingle(User::class.java)
    }
}