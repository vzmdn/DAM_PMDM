package com.example.examenviewmodel

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenviewmodel.databinding.ActivitySensorsBinding
import com.example.examenviewmodel.databinding.SensorBinding

class SensorsActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySensorsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySensorsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        val hardwareSensorList = sensorManager.getSensorList(android.hardware.Sensor.TYPE_ALL)

        val sensorList = hardwareSensorList.map { hardwareSensor ->
            Sensor(hardwareSensor.name, hardwareSensor.stringType,hardwareSensor.vendor, hardwareSensor.power)
        }

        val recyclerView = binding.recyclerView

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = SensorAdapter(sensorList)
    }

}