package com.example.mvvmproject.ui.base.main.view.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mvvmproject.data.CompanyItem
import com.example.mvvmproject.data.repository.CompanyRepository

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