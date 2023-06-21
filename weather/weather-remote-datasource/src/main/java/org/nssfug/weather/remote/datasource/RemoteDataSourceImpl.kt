package org.nssfug.weather.remote.datasource

import org.nssfug.weather.datasource.RemoteDataSource
import org.nssfug.weather.datasource.model.LocationDataModel
import org.nssfug.weather.datasource.model.WeatherConditionDataModel
import org.nssfug.weather.remote.datasource.mapper.LocationDataToRemoteMapper
import org.nssfug.weather.remote.datasource.mapper.WeatherConditionRemoteDataMapper
import org.nssfug.weather.remote.datasource.model.LocationRemoteModel
import org.nssfug.weather.remote.datasource.model.WeatherConditionRemoteModel

const val API_KEY = "951e08b53e9457fdbce60700a0bf10df";

class RemoteDataSourceImpl(
    private val weatherService: RetrofitWeatherService,
    private val locationDataToRemoteMapper: LocationDataToRemoteMapper,
    private val weatherConditionRemoteDataMapper: WeatherConditionRemoteDataMapper
): RemoteDataSource {
    override suspend fun getRemoteLocationDailyWeatherConditions(location: LocationDataModel): List<WeatherConditionDataModel> {
        val query = locationDataToRemoteMapper.toRemote(location)
            .toQueryMap()
            .toMutableMap()
            .apply {
                put("units", "metric")
            }

        return weatherService.getCurrentWeatherForecastData(query).list.map(weatherConditionRemoteDataMapper::toData)
    }

    override suspend fun getRemoteCurrentWeatherCondition(location: LocationDataModel): WeatherConditionDataModel {
        val query = locationDataToRemoteMapper.toRemote(location)
            .toQueryMap()
            .toMutableMap()
            .apply {
                put("units", "metric")
            }
        return weatherConditionRemoteDataMapper.toData(weatherService.getCurrentWeatherData(query))
    }

    private fun LocationRemoteModel.toQueryMap() = mapOf(
        "lat" to this.lat.toString(),
        "lon" to this.lon.toString(),
        "apiKey" to API_KEY
    )

}