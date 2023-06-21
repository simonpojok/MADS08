package org.nssfug.weather.domain.model

data class FavoriteWeatherConditionDomainModel(
    val location: LocationDomainModel,
    val currentWeatherCondition: WeatherConditionDomainModel,
    val locationWeatherForecast: List<WeatherConditionDomainModel>
)