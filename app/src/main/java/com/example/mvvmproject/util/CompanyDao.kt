package com.example.mvvmproject.util

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmproject.dto.CompanyItem

@Dao
interface CompanyDao {
    @Query("SELECT * FROM company ORDER BY company_name ASC")
    fun getAll(): LiveData<List<CompanyItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(companyItem: CompanyItem)

    @Delete
    fun delete(companyItem: CompanyItem)
}