package com.example.mvvmproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmproject.repository.MainRepository
import com.example.mvvmproject.util.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getUsers(name: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers(name)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getRepo(owner: String, repo: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getRepo(owner, repo)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error!"))
        }
    }
}