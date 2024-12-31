package com.vozmediano.repaso

import android.Manifest.permission.RECORD_AUDIO
import android.content.pm.PackageManager
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.vozmediano.repaso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val nombres = listOf("getafe", "barcelona", "bilbao", "real_madrid", "valencia")

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initViews()
        initListeners()
    }

    private fun initListeners() {
        val listener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                onEscudoClick()
            }
        }

        binding.image.setOnClickListener(listener)

        binding.permissionButton.setOnClickListener { (onStartRecording()) }
    }

    private fun onStartRecording() {
        if (!isRecordingPermissionGranted()) {
            Toast
                .makeText(this, "no tienes permiso de grabación", LENGTH_LONG)
                .show()
            requestPermissions(arrayOf(RECORD_AUDIO), 0)
        } else {
            startRecording()
        }
    }

    private fun startRecording() {
        Toast
            .makeText(this, "iniciando grabación...", LENGTH_LONG)
            .show()
    }

    fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
        deviceId: Int
    ) {
        if (grantResults[0] == PERMISSION_GRANTED) {
            startRecording()
            Log.i("y","ahora sí que tengo permiso")
        }
    }


    fun isRecordingPermissionGranted():Boolean{
        return PackageManager.PERMISSION_GRANTED == checkSelfPermission(android.Manifest.permission.RECORD_AUDIO)

    }

    fun onEscudoClick(){
        val nombre = nombres[nombres.indices.random()]
        setEscudoImage(nombre)
        binding.nombre.text = nombre
    }

    private fun initViews() {

        binding.nombre.text = "Este es mi escudo"

        val nombre = nombres[0]

        setEscudoImage(nombre)
    }

    private fun setEscudoImage(nombre: String) {


        val escudoUrl =
            "https://github.com/rafapuig/PMDM7N_2024/blob/master/escudos/${nombre}.png?raw=true"

        Glide
            .with(this)
            .load(escudoUrl)
            .into(binding.image)
    }
}