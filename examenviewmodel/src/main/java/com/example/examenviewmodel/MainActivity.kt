package com.example.examenviewmodel

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.examenviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var imageView : ImageView
    lateinit var btnPickTeam : Button
    lateinit var btnSensors : Button
    private val viewModel: MainViewModel by viewModels()

    private val pickTeamLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val teamName = data?.getStringExtra("selectedTeamName")
            val teamUrl = data?.getStringExtra("selectedTeamUrl")
            if (teamName != null && teamUrl != null) {
                val selectedTeam = Team(teamName, teamUrl)
                viewModel.setSelectedTeam(selectedTeam)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageView = binding.imageView
        btnPickTeam = binding.btnPickTeam
        btnSensors = binding.btnSensors


        initListeners()
    }

    private fun initListeners() {
        btnPickTeam.setOnClickListener {
            val pickTeamActivity = Intent(this, PickTeamActivity::class.java)
            viewModel.selectedTeam.value?.let {
                pickTeamActivity.putExtra("selectedTeamName", it.name)
                pickTeamActivity.putExtra("selectedTeamUrl", it.url)
            }
            pickTeamLauncher.launch(pickTeamActivity)
        }

        viewModel.selectedTeam.observe(this) { team ->
            team?.let {
                viewModel.selectTeamBackground(it.url)
            }
        }

        viewModel.selectedTeamBackground.observe(this) { url ->
            Glide.with(this)
                .load(url)
                .error(R.drawable.ic_launcher_background) // Add a placeholder error image
                .into(imageView)
        }


        btnSensors.setOnClickListener {
            val sensorsActivity = Intent(this, SensorsActivity::class.java)
            startActivity(sensorsActivity)
        }
    }


}