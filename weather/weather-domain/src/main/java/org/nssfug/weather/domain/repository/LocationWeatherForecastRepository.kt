package org.nssfug.weather.domain.repository

import org.nssfug.weather.domain.model.WeatherConditionDomainModel

interface LocationWeatherForecastRepository {
    suspend fun getLocationDailyWeatherConditions(
        longitude: Double,
        latitude: Double
    ): List<WeatherConditionDomainModel>
}