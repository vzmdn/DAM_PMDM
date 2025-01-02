package com.example.examenviewmodel

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
    val viewModel: MainViewModel by viewModels()

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

        initListeners()

    }
    fun initListeners() {
        btnConfirm = binding.btnConfirm
        btnCancel = binding.btnCancel

    }
}