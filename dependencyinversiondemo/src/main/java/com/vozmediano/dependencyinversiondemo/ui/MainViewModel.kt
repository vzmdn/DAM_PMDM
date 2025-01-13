package com.vozmediano.dependencyinversiondemo.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.vozmediano.dependencyinversiondemo.InversionDemoApp
import com.vozmediano.dependencyinversiondemo.domain.MainRepository

class MainViewModel(val repository : MainRepository) : ViewModel() {

    fun getForecast() = repository.getForecast()

    companion object{
        val Factory : ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {

                val application = extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]

                val repository : MainRepository = (application as InversionDemoApp).repository

                return MainViewModel(repository) as T

            }
        }
    }

}