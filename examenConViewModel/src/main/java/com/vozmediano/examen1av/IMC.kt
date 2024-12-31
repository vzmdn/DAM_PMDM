package com.vozmediano.examen1av

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vozmediano.examen1av.databinding.ActivityImcBinding

class IMC : AppCompatActivity() {

    private lateinit var binding: ActivityImcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculateImc.setOnClickListener {
            var weight = binding.etWeight.text.toString().toDoubleOrNull()
            var height = binding.etHeight.text.toString().toDoubleOrNull()

            if (weight != null && height != null) {
                //peso dividido por la altura al cuadrado
                height /= 100
                val imc = weight / (height * height)



                val intent = Intent(this, IMCResultActivity::class.java).apply {
                    putExtra("IMC_VALUE", imc)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, introduce valores válidos", Toast.LENGTH_SHORT).show()
            }
        }
    }

}