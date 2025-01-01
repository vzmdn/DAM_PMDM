package com.example.examenviewmodel

data class Team (val name:String, val url:String) {
    companion object {
        val teams = listOf(
            Team(
                "Real Madrid",
                "https://github.com/rafapuig/PMDM7N_2024/blob/master/escudos/real_madrid.png?raw=true"
            ),
            Team(
                "Barcelona",
                "https://github.com/rafapuig/PMDM7N_2024/blob/master/escudos/barcelona.png?raw=true"
            )
        )
    }
}