package org.nssfug.weather.datasource

import org.nssfug.weather.datasource.model.LocationDataModel
import org.nssfug.weather.datasource.model.WeatherConditionDataModel

interface LocalDataSource {
    suspend fun getLocalLocationDailyWeatherConditions(location: LocationDataModel): List<WeatherConditionDataModel>
    suspend fun getLocalCurrentWeatherCondition(location: LocationDataModel): WeatherConditionDataModel

}