package com.vozmediano.dependencyinversiondemo.providers

import com.vozmediano.dependencyinversiondemo.data.MainRepositoryImpl2
import com.vozmediano.dependencyinversiondemo.domain.MainRepository

class LluviosoRepositoryProvider : RepositoryProvider {

    override fun getRepository(): MainRepository = MainRepositoryImpl2()

}