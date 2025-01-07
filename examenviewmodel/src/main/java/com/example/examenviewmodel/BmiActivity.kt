package com.example.examenviewmodel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenviewmodel.databinding.ActivityBmiBinding

class BmiActivity : AppCompatActivity() {

    lateinit var binding : ActivityBmiBinding
    lateinit var btnComputeIMC : Button
    private val viewModel: BmiViewModel by viewModels()
    var imc : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initListeners()

    }

    private fun initListeners() {
        btnComputeIMC = binding.btnComputeIMC
        btnComputeIMC.setOnClickListener {
            val weight = binding.etWeight.text.toString().toIntOrNull()
            val height = binding.etHeight.text.toString().toIntOrNull()
            if (weight != null) {
                viewModel.setWeight(weight)
            }
            if (height != null) {
                viewModel.setHeight(height)
            }
            imc = viewModel.computeIMC()
            val imcText = viewModel.textIMC()

            val imcResult: Intent = Intent(this, BmiResultActivity::class.java)
            imcResult.putExtra("imcText", imcText)

            val etIMC = binding.tvIMC
            val yourIMC = getString(R.string.your_imc_is)
            etIMC.text = "$yourIMC $imc"
            startActivity(imcResult)
        }
    }
}