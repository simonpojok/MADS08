package org.nssfug.weather.local.datasource.model

data class FavoriteWeatherConditionLocalModel(
    val locationEntity: LocationEntity,
    val currentWeatherCondition: WeatherConditionEntity,
    val locationWeatherForecast: List<WeatherConditionEntity>,

    )