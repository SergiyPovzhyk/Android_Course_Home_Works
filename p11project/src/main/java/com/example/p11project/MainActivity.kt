package com.example.p11project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import model.WeatherDto
import model.MainViewModel
import java.text.SimpleDateFormat
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private var date: TextView? = null
    private var icon: ImageView? = null
    private var temperature: TextView? = null
    private var tempFeelsLike: TextView? = null
    private var description: TextView? = null
    private var windSpd: TextView? = null

    private lateinit var weatherAdapter: WeatherAdapter
    private var weatherDto: WeatherDto? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()

        viewModel.weatherResult.observe(this) {
            renderWeatherCurrent(it)
        }

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        weatherAdapter = WeatherAdapter(weatherDto?.data ?: emptyList())
        recyclerView.apply {
            adapter = weatherAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun initUI() {
        date = findViewById(R.id.date)
        icon = findViewById(R.id.icon)
        temperature = findViewById(R.id.temperature)
        tempFeelsLike = findViewById(R.id.temp_feels_like)
        description = findViewById(R.id.description)
        windSpd = findViewById(R.id.wind_spd)
    }

    private fun renderWeatherCurrent(weatherDto: WeatherDto) {
        if (weatherDto.data[0].datetime != null) {
            val parser = SimpleDateFormat("yyyy-MM-dd:")
            val formatter = SimpleDateFormat("dd.MM.yyyy")
            val output: String = formatter.format(parser.parse(weatherDto.data[0].datetime))
            date?.text = output
        }
        weatherAdapter.data = weatherDto.data
        weatherAdapter.notifyDataSetChanged()

        temperature?.text = String.format("%d \u00B0", weatherDto.data[0].temp.roundToInt())
        tempFeelsLike?.text = String.format(
            "Відчувається як %d \u00B0",
            weatherDto.data[0].temp.roundToInt()
        )
        description?.text = weatherDto.data[0].weather.description
        windSpd?.text = String.format(
            "Вітер: %.2f" + " км/год, ",
            weatherDto.data[0].windSpd,
            weatherDto.data[0].windCdirFull
        )
    }
}