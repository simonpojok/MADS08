package org.nssfug.weather.local.datasource.mapper

import org.nssfug.common.local.datasource.mapper.DataToLocalMapper
import org.nssfug.weather.datasource.model.FavoriteWeatherConditionDataModel
import org.nssfug.weather.local.datasource.model.FavoriteWeatherConditionLocalModel

class FavoriteWeatherConditionDataToLocalMapper(
    private val locationDataToEntityMapper: LocationDataToEntityMapper,
    private val weatherConditionDataToEntityMapper: WeatherConditionDataToEntityMapper
) : DataToLocalMapper<FavoriteWeatherConditionDataModel, FavoriteWeatherConditionLocalModel> {
    override fun toLocal(data: FavoriteWeatherConditionDataModel) =
        FavoriteWeatherConditionLocalModel(
            locationEntity = locationDataToEntityMapper.toLocal(data.locationDataModel),
            currentWeatherCondition = weatherConditionDataToEntityMapper.toLocal(data.currentWeatherCondition),
            locationWeatherForecast = data.locationWeatherForecast.map(
                weatherConditionDataToEntityMapper::toLocal
            )
        )
}