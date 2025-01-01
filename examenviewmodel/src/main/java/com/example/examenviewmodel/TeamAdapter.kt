package com.example.examenviewmodel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide

class TeamAdapter(context: Context, private val teams: List<Team>) : ArrayAdapter<Team>(context, 0, teams) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: inflater.inflate(R.layout.team, parent, false)
        val team = getItem(position)
        val teamLogo: ImageView = view.findViewById(R.id.teamLogo)
        val teamName: TextView = view.findViewById(R.id.teamName)
        team?.let {
            teamName.text = it.name
            Glide.with(teamLogo.context).load(it.url).into(teamLogo)
        }
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getView(position, convertView, parent)
    }
}