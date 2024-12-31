package com.vozmediano.viewmodel1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    //private var centimetros = 0.0f
    private val _centimetros = MutableLiveData<Float>()
    private var pulgadas = 0.0f
    val centimetros : LiveData<Float> get() = _centimetros

    fun setPulgadas(pulgadas: Float) {
        this.pulgadas = pulgadas
        _centimetros.value = pulgadas * 2.54f
    }

    fun getCentimetros() = centimetros.value
}