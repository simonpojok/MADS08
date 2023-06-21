package org.nssfug.weather.datasource.repository

import org.nssfug.weather.datasource.LocalDataSource
import org.nssfug.weather.datasource.RemoteDataSource
import org.nssfug.weather.datasource.mapper.WeatherConditionDataToDomainMapper
import org.nssfug.weather.datasource.model.LocationDataModel
import org.nssfug.weather.datasource.model.WeatherConditionDataModel
import org.nssfug.weather.domain.model.WeatherConditionDomainModel
import org.nssfug.weather.domain.repository.LocationCurrentWeatherConditionRepository
import java.lang.Exception

class LocationCurrentWeatherConditionDataRepository(
    private val weatherConditionDataToDomainMapper: WeatherConditionDataToDomainMapper,
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): LocationCurrentWeatherConditionRepository {
    override suspend fun getCurrentWeatherCondition(
        latitude: Double,
        longitude: Double
    ): WeatherConditionDomainModel {
        val location = LocationDataModel(longitude, latitude)
        val weatherCondition = try {
            val remoteWeatherInfo: WeatherConditionDataModel = remoteDataSource.getRemoteCurrentWeatherCondition(location)
            localDataSource.saveWeatherCondition(remoteWeatherInfo, location)
            remoteWeatherInfo
        } catch (error: Exception) {
            localDataSource.getWeatherConditionLocation(location)
        }

        return weatherConditionDataToDomainMapper.toDomain(weatherCondition)
    }
}