package org.nssfug.weather.presentation.mappers

import org.nssfug.common.presentation.mapper.PresentationToDomainMapper
import org.nssfug.weather.domain.model.WeatherConditionDomainModel
import org.nssfug.weather.presentation.dashboard.WeatherConditionPresentationState

class WeatherConditionPresentationStateToWeatherConditionMapper(
    private val weatherConditionPresentationMapper: WeatherConditionPresentationToDomainMapper
) : PresentationToDomainMapper<WeatherConditionPresentationState.Result, WeatherConditionDomainModel> {
    override fun toDomain(presentation: WeatherConditionPresentationState.Result) =
        weatherConditionPresentationMapper.toDomain(presentation.weatherCondition)
}