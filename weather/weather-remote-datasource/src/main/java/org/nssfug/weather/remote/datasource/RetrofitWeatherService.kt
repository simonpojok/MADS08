package org.nssfug.weather.remote.datasource

import org.nssfug.weather.remote.datasource.model.WeatherConditionRemoteModel
import org.nssfug.weather.remote.datasource.response.GetWeatherForecastResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RetrofitWeatherService {
    @GET("/data/2.5/weather")
    suspend fun getCurrentWeatherData(
        @QueryMap query: Map<String, String>
    ): WeatherConditionRemoteModel

    @GET("/data/2.5/forecast")
    suspend fun getCurrentWeatherForecastData(
        @QueryMap query: Map<String, String>
    ): GetWeatherForecastResponse
}