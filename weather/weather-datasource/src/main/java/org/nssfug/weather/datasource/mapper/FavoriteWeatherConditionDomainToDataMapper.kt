package org.nssfug.weather.datasource.mapper

import org.nssfug.common.datasource.mapper.DomainToDataMapper
import org.nssfug.weather.datasource.model.FavoriteWeatherConditionDataModel
import org.nssfug.weather.domain.model.FavoriteWeatherConditionDomainModel

class FavoriteWeatherConditionDomainToDataMapper(
    private val weatherConditionDomainMapper: WeatherConditionDomainToDataMapper,
    private val locationDomainToDataMapper: LocationDomainToDataMapper
) : DomainToDataMapper<FavoriteWeatherConditionDomainModel, FavoriteWeatherConditionDataModel> {
    override fun toData(domain: FavoriteWeatherConditionDomainModel) =
        FavoriteWeatherConditionDataModel(
            locationDataModel = locationDomainToDataMapper.toData(domain.location),
            currentWeatherCondition = weatherConditionDomainMapper.toData(domain.currentWeatherCondition),
            locationWeatherForecast = domain.locationWeatherForecast.map(
                weatherConditionDomainMapper::toData
            )
        )

}