package com.example.mvvmproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmproject.model.MuseumDataSource

class ViewModelFactory(private val repository:MuseumDataSource):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MuseumViewModel(repository) as T
    }
}