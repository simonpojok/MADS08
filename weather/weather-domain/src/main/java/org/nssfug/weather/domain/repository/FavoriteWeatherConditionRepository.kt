package org.nssfug.weather.domain.repository

import org.nssfug.weather.domain.model.FavoriteWeatherConditionDomainModel

interface FavoriteWeatherConditionRepository {
    suspend fun saveFavoriteWeatherCondition(weatherCondition: FavoriteWeatherConditionDomainModel)
}