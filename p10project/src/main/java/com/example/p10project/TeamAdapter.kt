package com.example.p10project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TeamAdapter : RecyclerView.Adapter<TeamAdapter.TeamHolder>(){
    val teamList = ArrayList<Team>()
    class TeamHolder(item:View): RecyclerView.ViewHolder(item){
        var textView:TextView? = null
        var imageView:ImageView? = null
        init {
            textView = item.findViewById(R.id.tvTittle)
            imageView = item.findViewById(R.id.imageView)
        }
        fun bind(team:Team){
            textView?.text = team.title
            imageView?.setImageResource(team.imageId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.team_item,parent,false)
        return TeamHolder(itemView)
    }

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        holder.bind(teamList[position])
    }

    override fun getItemCount(): Int {
        return teamList.size
    }

    fun addTeam(team: Team){
        teamList.add(team)
        notifyDataSetChanged()
    }
}