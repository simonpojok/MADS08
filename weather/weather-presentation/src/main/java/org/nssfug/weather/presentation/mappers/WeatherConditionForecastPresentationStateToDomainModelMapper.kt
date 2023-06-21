package org.nssfug.weather.presentation.mappers

import org.nssfug.common.presentation.mapper.PresentationToDomainMapper
import org.nssfug.weather.domain.model.WeatherConditionDomainModel
import org.nssfug.weather.presentation.dashboard.WeatherConditionForecastPresentationState

class WeatherConditionForecastPresentationStateToDomainModelMapper(
    private val weatherConditionPresentationMapper: WeatherConditionPresentationToDomainMapper
): PresentationToDomainMapper<WeatherConditionForecastPresentationState.Result, List<WeatherConditionDomainModel>> {
    override fun toDomain(presentation: WeatherConditionForecastPresentationState.Result) = presentation.items.map(weatherConditionPresentationMapper::toDomain)
}