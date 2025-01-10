package com.vozmediano.dependencyinversiondemo.data

import com.vozmediano.dependencyinversiondemo.domain.MainRepository

class MainRepositoryImpl2 : MainRepository{

    override
    fun getForecast(): String = "Lluvia torrencial"

}