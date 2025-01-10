package com.vozmediano.dependencyinversiondemo.data

import com.vozmediano.dependencyinversiondemo.domain.MainRepository

class MainRepositoryImpl : MainRepository{

    override
    fun getForecast(): String = "Soleado"

}