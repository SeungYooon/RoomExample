package com.example.mvvmproject.network

interface OperationCallback<T> {
    fun onSuccess(data:List<T>?)
    fun onError(error:String?)
}