package com.vozmediano.dependencyinversiondemo

import android.app.Application
import com.vozmediano.dependencyinversiondemo.domain.MainRepository
import com.vozmediano.dependencyinversiondemo.providers.LluviosoRepositoryProvider
import com.vozmediano.dependencyinversiondemo.providers.RepositoryProvider
import com.vozmediano.dependencyinversiondemo.providers.SoleadoRepositoryProvider

class InversionDemoApp : Application() {

        val repositoryProvider : RepositoryProvider = SoleadoRepositoryProvider()
        val repository :MainRepository = repositoryProvider.getRepository()

}