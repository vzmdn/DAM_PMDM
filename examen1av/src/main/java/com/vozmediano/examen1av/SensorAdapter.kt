package com.vozmediano.examen1av

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vozmediano.examen1av.databinding.ItemSensorBinding

class SensorAdapter(private val sensorList: List<Sensor>) : RecyclerView.Adapter<SensorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SensorViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_sensor, parent, false)

        return SensorViewHolder(view)
    }

    override fun getItemCount(): Int = sensorList.size

    override fun onBindViewHolder(holder: SensorViewHolder, position: Int) {
        val sensor = sensorList[position]
        holder.bind(sensor)
    }
}

class SensorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemSensorBinding.bind(itemView)

    fun bind(sensor: Sensor) {
        binding.sensorName.text = sensor.name
        binding.sensorType.text = sensor.type
        binding.sensorVendor.text = sensor.vendor
        binding.sensorPower.text = "${sensor.power} mA"

    }
}