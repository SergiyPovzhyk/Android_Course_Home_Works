package com.example.p11project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import model.Data
import java.text.SimpleDateFormat
import kotlin.math.roundToInt


class WeatherAdapter(var data: List<Data>) :
    RecyclerView.Adapter<WeatherAdapter.WeatherHourlyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHourlyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_weather, parent, false)
        return WeatherHourlyViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherHourlyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class WeatherHourlyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        private val temperature = itemView.findViewById<TextView>(R.id.temperature_hour)
        private val time = itemView.findViewById<TextView>(R.id.time)

        fun bind(
            data: Data
        ) {
            if (data.timestampLocal != null) {
                val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                val formatter = SimpleDateFormat("HH:mm")
                val output: String = formatter.format(parser.parse(data.timestampLocal))
                time.text = output
            }
            temperature?.text =
                String.format("%d \u00B0" + "C", data.temp.roundToInt())

        }
    }
}