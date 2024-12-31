package com.vozmediano.examen1av

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.vozmediano.examen1av.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            val imageView = binding.escudo

            Glide.with(this)
                .load("https://github.com/rafapuig/PMDM7N_2024/blob/master/escudos/real_madrid.png?raw=true")
                .into(imageView)

            insets
        }

        binding.btnComputeIMC.setOnClickListener {
            val intent = Intent(this, IMC::class.java)
            startActivity(intent)
        }

        binding.btnListSensors.setOnClickListener {
            val intent = Intent(this, SensorListActivity::class.java)
            startActivity(intent)
        }
    }
}