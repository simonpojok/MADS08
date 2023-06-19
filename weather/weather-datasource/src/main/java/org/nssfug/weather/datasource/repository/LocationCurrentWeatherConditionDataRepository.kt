package org.nssfug.weather.datasource.repository

import org.nssfug.weather.datasource.LocalDataSource
import org.nssfug.weather.datasource.RemoteDataSource
import org.nssfug.weather.datasource.mapper.WeatherConditionDataToDomainMapper
import org.nssfug.weather.datasource.model.LocationDataModel
import org.nssfug.weather.domain.model.WeatherConditionDomainModel
import org.nssfug.weather.domain.repository.LocationCurrentWeatherConditionRepository

class LocationCurrentWeatherConditionDataRepository(
    private val weatherConditionDataToDomainMapper: WeatherConditionDataToDomainMapper,
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): LocationCurrentWeatherConditionRepository {
    override suspend fun getCurrentWeatherCondition(
        latitude: Double,
        longitude: Double
    ) = weatherConditionDataToDomainMapper.toDomain(remoteDataSource.getRemoteCurrentWeatherCondition(LocationDataModel(longitude, latitude)))
}