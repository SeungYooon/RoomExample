package com.example.mvvmproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmproject.repository.DetailRepository
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