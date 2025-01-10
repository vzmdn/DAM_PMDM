package com.vozmediano.dependencyinversiondemo.providers

import com.vozmediano.dependencyinversiondemo.domain.MainRepository

interface RepositoryProvider {

    fun getRepository(): MainRepository

}