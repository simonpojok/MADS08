package org.nssfug.weather.domain.repository

import org.nssfug.weather.domain.model.WeatherConditionDomainModel

interface LocationCurrentWeatherConditionRepository {
    suspend fun getCurrentWeatherCondition(
        latitude: Double,
        longitude: Double
    ): WeatherConditionDomainModel
}