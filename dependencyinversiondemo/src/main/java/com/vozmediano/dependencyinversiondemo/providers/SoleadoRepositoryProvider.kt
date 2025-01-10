package com.vozmediano.dependencyinversiondemo.providers

import com.vozmediano.dependencyinversiondemo.data.MainRepositoryImpl
import com.vozmediano.dependencyinversiondemo.domain.MainRepository

class SoleadoRepositoryProvider: RepositoryProvider {

    override fun getRepository(): MainRepository = MainRepositoryImpl()
}