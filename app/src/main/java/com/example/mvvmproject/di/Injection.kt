package com.example.mvvmproject.di

import androidx.lifecycle.ViewModelProvider
import com.example.mvvmproject.model.MuseumDataSource
import com.example.mvvmproject.model.MuseumRepository
import com.example.mvvmproject.viewmodel.ViewModelFactory

object Injection {

    private val museumDataSource: MuseumDataSource = MuseumRepository()
    private val museumViewModelFactory = ViewModelFactory(museumDataSource)

    fun provideRepository(): MuseumDataSource {
        return museumDataSource
    }

    fun provideViewModelFactory(): ViewModelProvider.Factory {
        return museumViewModelFactory
    }
}