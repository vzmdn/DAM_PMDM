package com.example.examenviewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.examenviewmodel.databinding.SensorBinding

class SensorAdapter(val sensorList:List<Sensor>) : RecyclerView.Adapter<SensorAdapter.SensorViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SensorViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.sensor, parent, false)

        return SensorViewHolder(view)
    }

    override fun onBindViewHolder(holder: SensorViewHolder, position: Int) {
        val sensor = sensorList[position]
        holder.bind(sensor)
    }

    override fun getItemCount(): Int = sensorList.size

    class SensorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = SensorBinding.bind(itemView)

        fun bind(sensor: Sensor) {
            binding.tvName.text = sensor.name
            binding.tvVendor.text = sensor.vendor
            sensor.power.toString().also { binding.tvPower.text = it }

        }
    }
}