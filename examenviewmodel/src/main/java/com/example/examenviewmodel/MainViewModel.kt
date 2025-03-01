package com.example.examenviewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val _spinnerItems = MutableLiveData<List<Team>>()
    val spinnerItems: LiveData<List<Team>> = _spinnerItems

    val _selectedTeam = MutableLiveData<Team>()
    val selectedTeam: LiveData<Team> = _selectedTeam

    private val _selectedTeamBackground = MutableLiveData<String>()
    val selectedTeamBackground: LiveData<String> get() = _selectedTeamBackground

    init {
        _spinnerItems.value = Team.teams
    }

    fun onItemSelected(position: Int) {
        Log.i("test", "onItemSelected")
        _selectedTeam.value = Team.teams[position]
    }

    fun selectTeamBackground(url: String) {
        _selectedTeamBackground.value = url
    }

    fun setSelectedTeam(selectedTeam: Team) {
        _selectedTeam.value = selectedTeam
    }


}