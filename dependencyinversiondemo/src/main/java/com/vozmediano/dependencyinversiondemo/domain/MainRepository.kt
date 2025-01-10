package com.vozmediano.dependencyinversiondemo.domain

interface MainRepository {

    fun getForecast(): String
}