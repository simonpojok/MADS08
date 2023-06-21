package org.nssfug.weather.datasource.model

data class FavoriteWeatherConditionDataModel(
    val locationDataModel: LocationDataModel,
    val currentWeatherCondition: WeatherConditionDataModel,
    val locationWeatherForecast: List<WeatherConditionDataModel>
)