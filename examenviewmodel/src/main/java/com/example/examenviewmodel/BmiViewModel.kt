package com.example.examenviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {
    private var _weight: MutableLiveData<Int> = MutableLiveData(0)
    val weight: LiveData<Int> = _weight

    private var _height: MutableLiveData<Int> = MutableLiveData(0)
    val height: LiveData<Int> = _height

    private var _imc: MutableLiveData<Double> = MutableLiveData(0.0)
    var imc: LiveData<Double> = _imc

    fun setWeight(value: Int) {
        _weight.value = value
    }

    fun setHeight(value: Int) {
        _height.value = value
    }

    fun computeIMC(): Double {
        val weightValue = _weight.value ?: 0
        val heightValue = _height.value ?: 0
        if (heightValue > 0) {
            val heightInMeters: Double = heightValue / 100.0
            val computedIMC = (weightValue / (heightInMeters * heightInMeters))
            _imc.value = computedIMC
            return computedIMC
  }
        else return 0.0
    }

    fun textIMC(): String {
        val textResult :String = when {
            imc.value!! < 18.5 -> "Underweight"
            imc.value!! < 25 -> "Normal weight"
            imc.value!! < 30 -> "Overweight"
            else -> "Obesity"
        }
        return textResult
    }


}