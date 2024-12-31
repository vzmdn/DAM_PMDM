package com.vozmediano.spinnerapp

data class Pokemon(val name: String, val overall: Int) {
    override fun toString(): String {
        return "${name} has ${overall} stat product"
    }
}