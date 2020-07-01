package com.example.mvvmproject.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mvvmproject.data.CompanyItem
import com.example.mvvmproject.data.CompanyDao
import com.example.mvvmproject.data.CompanyDatabase
import java.lang.Exception

class CompanyRepository(application: Application) {

    private val companyDatabase = CompanyDatabase.getInstance(application)!!
    private val companyDao: CompanyDao = companyDatabase.contactDao()
    private val company: LiveData<List<CompanyItem>> = companyDao.getAll()

    fun getAll(): LiveData<List<CompanyItem>> {
        return company
    }

    fun insert(companyItem: CompanyItem) {
        try {
            val thread = Thread(Runnable {
                companyDao.insert(companyItem)
            })
            thread.start()
        } catch (e: Exception) {
        }
    }

    fun delete(companyItem: CompanyItem) {
        try {
            val thread = Thread(Runnable {
                companyDao.delete(companyItem)
            })
            thread.start()
        } catch (e: Exception) {
        }
    }
}