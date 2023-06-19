package org.nssfug.weather.remote.datasource.response

import org.nssfug.weather.remote.datasource.model.WeatherConditionRemoteModel

data class GetWeatherForecastResponse(
    val list: List<WeatherConditionRemoteModel>
)