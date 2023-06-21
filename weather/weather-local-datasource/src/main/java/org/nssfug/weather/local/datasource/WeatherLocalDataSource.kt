package org.nssfug.weather.local.datasource

import com.google.gson.Gson
import org.nssfug.weather.datasource.LocalDataSource
import org.nssfug.weather.datasource.model.FavoriteWeatherConditionDataModel
import org.nssfug.weather.datasource.model.LocationDataModel
import org.nssfug.weather.datasource.model.WeatherConditionDataModel
import org.nssfug.weather.local.datasource.dao.LocationEntityDao
import org.nssfug.weather.local.datasource.mapper.FavoriteWeatherConditionDataToLocalMapper

class WeatherLocalDataSource(
    private val locationEntityDao: LocationEntityDao,
    private val favoriteWeatherConditionDataToLocalMapper: FavoriteWeatherConditionDataToLocalMapper
) : LocalDataSource {
    override suspend fun getLocalLocationDailyWeatherConditions(location: LocationDataModel): List<WeatherConditionDataModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getLocalCurrentWeatherCondition(location: LocationDataModel): WeatherConditionDataModel {
        TODO("Not yet implemented")
    }

    override suspend fun saveFavoriteWeatherCondition(favoriteWeatherConditionDataModel: FavoriteWeatherConditionDataModel) {
        val localEntities =
            favoriteWeatherConditionDataToLocalMapper.toLocal(favoriteWeatherConditionDataModel)
        val weatherCondition = Gson().toJson(localEntities)

        locationEntityDao.insertLocation(
            localEntities.locationEntity.apply {
                this.weatherConditionData = weatherCondition
                this.isFavourite = true
            }
        )

    }
}