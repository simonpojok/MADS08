package org.nssfug.weather.ui

import org.nssfug.weather.ui.mapper.MetaInformationPresentationToUiMapper
import org.nssfug.weather.ui.mapper.TempMeasurementPresentationToUiMapper
import org.nssfug.weather.ui.mapper.WeatherConditionPresentationToUiMapper

interface MainWeatherContext {
    val metaInformationPresentationToUiMapper: MetaInformationPresentationToUiMapper
    val tempMeasurementPresentationToUiMapper: TempMeasurementPresentationToUiMapper
    val weatherConditionPresentationToUiMapper: WeatherConditionPresentationToUiMapper
}