package com.example.mvvmproject.ui.base.main.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmproject.data.repository.DetailRepository
import com.example.mvvmproject.util.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class DetailViewModel(private val detailRepository: DetailRepository) : ViewModel() {

    fun getDetail(username: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = detailRepository.getDetail(username)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occured!"))
        }
    }
}