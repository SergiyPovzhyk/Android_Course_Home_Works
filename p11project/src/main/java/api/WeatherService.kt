package api


import model.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val BASE_URL = "https://weatherbit-v1-mashape.p.rapidapi.com"
interface WeatherService {
    @Headers("X-RapidAPI-Key: dcaf510d9cmshc125dc83a14930ap19a399jsnb0a17d9385f3")
    @GET("current?lang=ru")
    fun getWeatherCurrent(
        @Query("lat") lat: Float,
        @Query("lon") lon: Float
    ): Call<Weather>

    @Headers("X-RapidAPI-Key: dcaf510d9cmshc125dc83a14930ap19a399jsnb0a17d9385f3")
    @GET("forecast/hourly?lang=ru")
    fun getWeatherHourly(
        @Query("lat") lat: Float,
        @Query("lon") lon: Float
    ): Call<Weather>
}
