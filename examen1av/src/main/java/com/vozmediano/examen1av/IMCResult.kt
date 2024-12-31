package com.vozmediano.examen1av

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vozmediano.examen1av.databinding.ActivityImcResultBinding

class IMCResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImcResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imc = intent.getDoubleExtra("IMC_VALUE", 0.0)

        val result = when {
            imc < 18.5 -> "Inferior al normal"
            imc < 25 -> "Normal"
            imc < 30 -> "Sobrepeso"
            else -> "Obesidad"
        }

        binding.tvImcResult.text = result

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}