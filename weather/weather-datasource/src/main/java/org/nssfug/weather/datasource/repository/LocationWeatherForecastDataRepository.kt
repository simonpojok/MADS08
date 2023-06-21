package org.nssfug.weather.datasource.repository

import org.nssfug.weather.datasource.LocalDataSource
import org.nssfug.weather.datasource.RemoteDataSource
import org.nssfug.weather.datasource.mapper.WeatherConditionDataToDomainMapper
import org.nssfug.weather.datasource.model.LocationDataModel
import org.nssfug.weather.datasource.model.WeatherConditionDataModel
import org.nssfug.weather.domain.model.WeatherConditionDomainModel
import org.nssfug.weather.domain.repository.LocationWeatherForecastRepository
import java.lang.Exception

class LocationWeatherForecastDataRepository(
    private val weatherConditionDataToDomainMapper: WeatherConditionDataToDomainMapper,
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : LocationWeatherForecastRepository {
    override suspend fun getLocationDailyWeatherConditions(
        longitude: Double,
        latitude: Double
    ): List<WeatherConditionDomainModel> {
        val location = LocationDataModel(
            longitude,
            latitude
        )
        val weatherConditions: List<WeatherConditionDataModel> = try {
            val weatherConditionsResponse =
                remoteDataSource.getRemoteLocationDailyWeatherConditions(
                    location
                )
            localDataSource.saveLocationDailyWeatherConditions(weatherConditionsResponse, location)
            weatherConditionsResponse
        } catch (exception: Exception) {
            localDataSource.getLocalLocationDailyWeatherConditions(location)
        }

        return weatherConditions.map(weatherConditionDataToDomainMapper::toDomain)
    }
}