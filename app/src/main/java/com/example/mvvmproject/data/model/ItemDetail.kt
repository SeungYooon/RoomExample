package com.example.mvvmproject.data.model

import com.google.gson.annotations.SerializedName

data class ItemDetail(
    @SerializedName("followers")
    var followers: Int,
    @SerializedName("following")
    var following: Int
)