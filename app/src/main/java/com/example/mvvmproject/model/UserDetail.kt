package com.example.mvvmproject.model

import com.google.gson.annotations.SerializedName

data class UserDetail(
    @SerializedName("followers")
    var followers: Int,
    @SerializedName("following")
    var following: Int
)