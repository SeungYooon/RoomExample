package com.example.mvvmproject.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmproject.data.api.DetailHelper
import com.example.mvvmproject.data.repository.DetailRepository
import com.example.mvvmproject.ui.base.main.view.viewmodel.DetailViewModel
import java.lang.IllegalArgumentException

class DetailViewModelFactory(private val detailHelper: DetailHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(DetailRepository(detailHelper)) as T
        }
        throw IllegalArgumentException("Unkown class")
    }
}