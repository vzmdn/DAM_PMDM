package com.example.examenviewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.examenviewmodel.databinding.ActivityMainBinding
import android.content.Context

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

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

        val imageView = binding.imageView
        val imageUrl = "https://lh3.googleusercontent.com/CJjlgc12WpgPF3AHelmcC6-nusOX_9aSjFdlAJxHjZ8uw5JOJ-mZjgoQhGBrKOyHgnQ6gLaUbzDgOP7y8RUlRzQgikCmq4iEnaO7UWI=w1064-v0"

            Glide.with(this)
                .load(imageUrl)
                .error(R.drawable.ic_launcher_background) // Add a placeholder error image
                .into(imageView)

    }
}