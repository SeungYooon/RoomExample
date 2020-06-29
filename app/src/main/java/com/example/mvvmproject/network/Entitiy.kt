package com.example.mvvmproject.network

import com.example.mvvmproject.model.Museum

data class MuseumResponse(val status:Int?,val msg:String?,val data:List<Museum>?){
    fun isSuccess():Boolean= (status==200)
}