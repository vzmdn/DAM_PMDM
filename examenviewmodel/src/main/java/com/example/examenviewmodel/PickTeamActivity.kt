package com.example.examenviewmodel

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenviewmodel.databinding.ActivityPickTeamBinding

class PickTeamActivity : AppCompatActivity() {

    lateinit var binding: ActivityPickTeamBinding
    lateinit var spinner: Spinner
    lateinit var btnConfirm: Button
    lateinit var btnCancel: Button
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityPickTeamBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinner = binding.spinner
        viewModel.spinnerItems.observe(this) { teams ->
            val adapter = TeamAdapter(this, teams)
            spinner.adapter = adapter
        }

        // Retrieve the selected team from the intent
        val selectedTeamName = intent.getStringExtra("selectedTeamName")
        val selectedTeamUrl = intent.getStringExtra("selectedTeamUrl")
        if (selectedTeamName != null && selectedTeamUrl != null) {
            val selectedTeam = Team(selectedTeamName, selectedTeamUrl)
            viewModel.setSelectedTeam(selectedTeam)
        }

        viewModel.selectedTeam.observe(this) { selectedTeam ->
            selectedTeam?.let {
                val position = viewModel.spinnerItems.value?.indexOf(it) ?: -1
                if (position >= 0) {
                    spinner.setSelection(position)
                }
            }
        }

        initListeners()
    }

    fun initListeners() {
        btnConfirm = binding.btnConfirm

        btnConfirm.setOnClickListener {
            val position = spinner.selectedItemPosition
            viewModel.onItemSelected(position)
            val selectedTeam = viewModel.selectedTeam.value
            val resultIntent = Intent()
            resultIntent.putExtra("selectedTeamName", selectedTeam?.name)
            resultIntent.putExtra("selectedTeamUrl", selectedTeam?.url)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        btnCancel = binding.btnCancel
        btnCancel.setOnClickListener {
            finish()
        }
    }
}