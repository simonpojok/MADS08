package org.nssfug.weather.datasource.repository

import org.nssfug.weather.datasource.LocalDataSource
import org.nssfug.weather.domain.model.FavoriteWeatherConditionDomainModel
import org.nssfug.weather.domain.repository.FavoriteWeatherConditionRepository

class FavoriteWeatherConditionDataRepository(
    private val localDataSource: LocalDataSource
): FavoriteWeatherConditionRepository {
    override suspend fun saveFavoriteWeatherCondition(weatherCondition: FavoriteWeatherConditionDomainModel) {
        TODO("Not yet implemented")
    }
}