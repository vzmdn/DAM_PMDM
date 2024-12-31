package com.vozmediano.viewmodel1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.vozmediano.viewmodel1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    //val mainViewModel = MainViewModel()
    private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initListeners()
        //updateUI()

        mainViewModel.centimetros.observe(this){
            updateUI()
        }


    }

    private fun initListeners() {
        binding.btnConvertir.setOnClickListener{onCalcular()}
    }

    //var centimetros = 0.0f

    private fun onCalcular() {
        val pulgadas = binding.etPulgadas.text.toString().toFloatOrNull()?: 0.0f
        //centimetros = pulgadas * 2.54f
        mainViewModel.setPulgadas(pulgadas)
        //updateUI()
    }

    fun updateUI(){
        binding.centimetros.text = mainViewModel.getCentimetros().toString()
    }
}