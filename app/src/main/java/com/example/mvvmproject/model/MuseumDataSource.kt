package com.example.mvvmproject.model

import com.example.mvvmproject.network.OperationCallback

interface MuseumDataSource {

    fun retrieveMuseums(callback: OperationCallback<Museum>)
    fun cancel()
}