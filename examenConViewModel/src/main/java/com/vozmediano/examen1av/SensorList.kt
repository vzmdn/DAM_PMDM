package com.vozmediano.examen1av

import android.content.Context
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vozmediano.examen1av.databinding.ActivitySensorListBinding

class SensorListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySensorListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySensorListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val hardwareSensorList = sensorManager.getSensorList(android.hardware.Sensor.TYPE_ALL)

        val sensorList = hardwareSensorList.map { hardwareSensor ->
            Sensor(hardwareSensor.name, hardwareSensor.stringType,hardwareSensor.vendor, hardwareSensor.power)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = SensorAdapter(sensorList)
    }
}