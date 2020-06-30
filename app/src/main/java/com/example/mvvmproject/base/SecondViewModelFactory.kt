package com.example.mvvmproject.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmproject.network.api.ApiHelper
import com.example.mvvmproject.repository.MainRepository
import com.example.mvvmproject.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

class SecondViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unkown class Name")
    }
}