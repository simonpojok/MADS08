package org.nssfug.weather.datasource.repository

import org.nssfug.weather.datasource.LocalDataSource
import org.nssfug.weather.datasource.RemoteDataSource
import org.nssfug.weather.datasource.mapper.WeatherConditionDataToDomainMapper
import org.nssfug.weather.datasource.model.LocationDataModel
import org.nssfug.weather.domain.repository.LocationWeatherForecastRepository

class LocationWeatherForecastDataRepository(
    private val weatherConditionDataToDomainMapper: WeatherConditionDataToDomainMapper,
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : LocationWeatherForecastRepository {
    override suspend fun getLocationDailyWeatherConditions(
        longitude: Double,
        latitude: Double
    ) = remoteDataSource.getRemoteLocationDailyWeatherConditions(LocationDataModel(longitude, latitude))
        .map(weatherConditionDataToDomainMapper::toDomain)
}