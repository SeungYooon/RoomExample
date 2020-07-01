package com.example.mvvmproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CompanyItem::class], version = 2)
abstract class CompanyDatabase : RoomDatabase() {

    abstract fun contactDao(): CompanyDao

    companion object {
        private var INSTANCE: CompanyDatabase? = null

        fun getInstance(context: Context): CompanyDatabase? {
            if (INSTANCE == null) {
                synchronized(CompanyDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CompanyDatabase::class.java, "contact"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}