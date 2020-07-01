package com.example.mvvmproject.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmproject.data.api.UserHelper
import com.example.mvvmproject.data.repository.UserRepository
import com.example.mvvmproject.ui.base.main.view.viewmodel.UserViewModel
import java.lang.IllegalArgumentException

class UserModelFactory(private val userHelper: UserHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(UserRepository(userHelper)) as T
        }
        throw IllegalArgumentException("Unkown class name")
    }
}