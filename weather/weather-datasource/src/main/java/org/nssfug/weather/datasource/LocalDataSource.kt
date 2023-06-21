package org.nssfug.weather.datasource

import org.nssfug.weather.datasource.model.FavoriteWeatherConditionDataModel
import org.nssfug.weather.datasource.model.LocationDataModel
import org.nssfug.weather.datasource.model.WeatherConditionDataModel

interface LocalDataSource {
    suspend fun getLocalLocationDailyWeatherConditions(location: LocationDataModel): List<WeatherConditionDataModel>
    suspend fun saveFavoriteWeatherCondition(favoriteWeatherConditionDataModel: FavoriteWeatherConditionDataModel)
    suspend fun saveWeatherCondition(
        weatherCondition: WeatherConditionDataModel,
        locationDataModel: LocationDataModel
    )

    suspend fun getWeatherConditionLocation(location: LocationDataModel): WeatherConditionDataModel
    suspend fun saveLocationDailyWeatherConditions(
        weatherConditions: List<WeatherConditionDataModel>,
        location: LocationDataModel
    )

}