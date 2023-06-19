package org.nssfug.weather.datasource

import org.nssfug.weather.datasource.model.LocationDataModel
import org.nssfug.weather.datasource.model.WeatherConditionDataModel

interface RemoteDataSource {
    suspend fun getRemoteLocationDailyWeatherConditions(location: LocationDataModel): List<WeatherConditionDataModel>
    suspend fun getRemoteCurrentWeatherCondition(location: LocationDataModel): WeatherConditionDataModel
}