package com.vozmediano.repasoexamen

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.vozmediano.repasoexamen.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var view: View
    lateinit var boton: View
    lateinit var spinner: View
    lateinit var botones: List<Boton>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        view = binding.view
        boton = binding.button
        spinner = binding.spinner
        botones = initBotones()


        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val spinner = binding.spinner

        val adapter = BotonAdapter(
            this,
            android.R.layout.simple_spinner_item,
            botones
        )
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                (boton as Button).text = botones[position].nombre
                boton.setOnClickListener(botones[position].listener)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }

    private fun initBotones(): List<Boton> {
        val onBtnSizeClick = View.OnClickListener {
            val height = ((30..300).random() * resources.displayMetrics.density).toInt()
            val width = ((30..300).random() * resources.displayMetrics.density).toInt()
            view.layoutParams.height = height
            view.layoutParams.width = width
            view.requestLayout()
        }

        val colors = listOf(
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.YELLOW,
            Color.CYAN,
            Color.MAGENTA,
            Color.DKGRAY,
            Color.LTGRAY,
            Color.WHITE
        )

        val onBtnColorClick = View.OnClickListener {
            val color = colors.random()
            view.setBackgroundColor(color)
            view.requestLayout()
        }

        val onBtnVisibilityClick = View.OnClickListener {
            val visibility: Boolean = view.isVisible
            if (visibility) view.visibility = View.INVISIBLE
            else view.visibility = View.VISIBLE
            view.requestLayout()
        }

        val btnSize = Boton("Change Size", onBtnSizeClick)
        val btnColor = Boton("Change Color", onBtnColorClick)
        val btnVisibility = Boton("Change Visibility", onBtnVisibilityClick)

        return listOf(btnSize, btnColor, btnVisibility)
    }
}
