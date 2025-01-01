package com.example.examenviewmodel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
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
    private lateinit var viewModel: MainViewModel

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


        /*
        val imageUrl = "https://lh3.googleusercontent.com/CJjlgc12WpgPF3AHelmcC6-nusOX_9aSjFdlAJxHjZ8uw5JOJ-mZjgoQhGBrKOyHgnQ6gLaUbzDgOP7y8RUlRzQgikCmq4iEnaO7UWI=w1064-v0"

            Glide.with(this)
                .load(imageUrl)
                .error(R.drawable.ic_launcher_background) // Add a placeholder error image
                .into(imageView)*/

    }

    private fun initListeners() {
        btnPickTeam.setOnClickListener {
            val pickTeamActivity = Intent(this, PickTeamActivity::class.java)
            startActivity(pickTeamActivity)
        }
    }
}