package com.example.mvvmproject.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company")
data class CompanyItem(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,

    @ColumnInfo(name = "company_name")
    var compnayName: String,

    @ColumnInfo(name = "company_location")
    var companyLocation: String,

    @ColumnInfo(name = "initial")
    var initial: Char
) {
    constructor() : this(null, "", "", '\u0000')
}