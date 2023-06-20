package org.nssfug.weather.local.datasource

import org.nssfug.weather.datasource.LocalDataSource
import org.nssfug.weather.datasource.model.LocationDataModel
import org.nssfug.weather.datasource.model.WeatherConditionDataModel

class WeatherLocalDataSource: LocalDataSource {
    override suspend fun getLocalLocationDailyWeatherConditions(location: LocationDataModel): List<WeatherConditionDataModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getLocalCurrentWeatherCondition(location: LocationDataModel): WeatherConditionDataModel {
        TODO("Not yet implemented")
    }
}