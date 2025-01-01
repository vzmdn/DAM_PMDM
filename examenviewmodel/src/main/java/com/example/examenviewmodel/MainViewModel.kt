package com.example.examenviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val _spinnerItems = MutableLiveData<List<Team>>()
    val spinnerItems: LiveData<List<Team>> = _spinnerItems

    val _selectedTeam = MutableLiveData<Team>()
    val selectedTeam: LiveData<Team> = _selectedTeam

    init {
        _spinnerItems.value = Team.teams
    }

    fun onItemSelected(position: Int) {
        _selectedTeam.value = Team.teams[position]
    }


}