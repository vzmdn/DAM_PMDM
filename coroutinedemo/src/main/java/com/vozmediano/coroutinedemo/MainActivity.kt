package com.vozmediano.coroutinedemo

import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.vozmediano.coroutinedemo.databinding.ActivityMainBinding
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //var count: Int = 1
    val viewModel: MainViewModel by viewModels()

    //xz
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

        initListeners();
    }

    private fun initListeners() {
        binding.button.setOnClickListener {
            launchCoroutines()
        }
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                viewModel.setCount(progress)
                binding.countText.text = "${viewModel.count.value} coroutines"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun launchCoroutines() {
        (1..viewModel.count.value!!).forEach{
            binding.statusText.text = "started corroutine $it"
            lifecycleScope.launch(Dispatchers.IO) {
                val future = viewModel.performTaskAsync(it)

            //aqui podria seguir haciendo tareas que no necesitan el resultado

                val message = future.await()

                //cambiamos el contexto a main para poder usar el binding
                withContext(Dispatchers.Main) {
                    binding.statusText.text = message
                }
            }

            //esto se ejecutaria sin esperar a la finalizacion de las corrutinas

        }
    }

}

