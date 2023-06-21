package org.nssfug.weather.local.datasource

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.nssfug.weather.datasource.LocalDataSource
import org.nssfug.weather.datasource.model.FavoriteWeatherConditionDataModel
import org.nssfug.weather.datasource.model.LocationDataModel
import org.nssfug.weather.datasource.model.WeatherConditionDataModel
import org.nssfug.weather.local.datasource.dao.LocationEntityDao
import org.nssfug.weather.local.datasource.mapper.FavoriteWeatherConditionDataToLocalMapper
import org.nssfug.weather.local.datasource.mapper.LocationDataToEntityMapper
import org.nssfug.weather.local.datasource.mapper.WeatherConditionDataToEntityMapper
import org.nssfug.weather.local.datasource.mapper.WeatherConditionEntityToDataMapper
import org.nssfug.weather.local.datasource.model.WeatherConditionEntity
import java.lang.IllegalArgumentException

class WeatherLocalDataSource(
    private val locationEntityDao: LocationEntityDao,
    private val favoriteWeatherConditionDataToLocalMapper: FavoriteWeatherConditionDataToLocalMapper,
    private val weatherConditionDataToEntityMapper: WeatherConditionDataToEntityMapper,
    private val locationDataToEntityMapper: LocationDataToEntityMapper,
    private val weatherConditionEntityMapper: WeatherConditionEntityToDataMapper
) : LocalDataSource {
    override suspend fun getLocalLocationDailyWeatherConditions(location: LocationDataModel): List<WeatherConditionDataModel> {
        val contentType = "CONDITIONS"
        val localLocation = locationEntityDao.getLocation(
            longitude = location.longitude,
            latitude = location.latitude,
            contentType = contentType
        ) ?: throw IllegalArgumentException("No Location Found")

        val sType = object : TypeToken<List<WeatherConditionEntity>>() {}.type

        val result =
            Gson().fromJson<List<WeatherConditionEntity>>(localLocation.weatherConditionData, sType)

        return Gson().fromJson<List<WeatherConditionEntity>>(
            localLocation.weatherConditionData,
            sType
        )
            .map(weatherConditionEntityMapper::toData)
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

    override suspend fun saveWeatherCondition(
        weatherCondition: WeatherConditionDataModel,
        locationDataModel: LocationDataModel
    ) {
        val contentType = "CONDITION"
        val locationEntity = locationDataToEntityMapper.toLocal(locationDataModel)
            .apply {
                weatherConditionData =
                    Gson().toJson(weatherConditionDataToEntityMapper.toLocal(weatherCondition))
                this.contentType = contentType
            }

        locationEntityDao.insertLocation(locationEntity)
    }

    override suspend fun getWeatherConditionLocation(location: LocationDataModel): WeatherConditionDataModel {
        val contentType = "CONDITION"
        val localLocation = locationEntityDao.getLocation(
            longitude = location.longitude,
            latitude = location.latitude,
            contentType = contentType
        ) ?: throw IllegalArgumentException("No Location Found")

        val result = Gson().fromJson(
            localLocation.weatherConditionData,
            WeatherConditionEntity::class.java
        )

        return weatherConditionEntityMapper.toData(result)
    }

    override suspend fun saveLocationDailyWeatherConditions(
        weatherConditions: List<WeatherConditionDataModel>,
        location: LocationDataModel
    ) {
        val contentType = "CONDITIONS"
        val locationEntity = locationDataToEntityMapper.toLocal(location)
            .apply {
                weatherConditionData =
                    Gson().toJson(weatherConditions.map(weatherConditionDataToEntityMapper::toLocal))
                this.contentType = contentType
            }

        locationEntityDao.insertLocation(locationEntity)
    }
}