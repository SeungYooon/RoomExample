package com.example.mvvmproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mvvmproject.dto.CompanyItem
import com.example.mvvmproject.repository.CompanyRepository

class CompanyViewModel(application: Application) : AndroidViewModel(application) {

    private val repository =
        CompanyRepository(application)
    private val contacts = repository.getAll()

    fun getAll(): LiveData<List<CompanyItem>> {
        return this.contacts
    }

    fun insert(companyItem: CompanyItem) {
        repository.insert(companyItem)
    }

    fun delete(companyItem: CompanyItem) {
        repository.delete(companyItem)
    }
}