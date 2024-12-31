package com.vozmediano.repasoexamen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class BotonAdapter (
    context:Context,
    resource:Int,
    objects:List<Boton>,
):ArrayAdapter<Boton>(context,resource,objects) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(android.R.layout.simple_spinner_item, parent, false)

        val boton = getItem(position)
        val textView: TextView = view.findViewById(android.R.id.text1)
        textView.text = boton?.nombre

        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getView(position, convertView, parent)
    }
}