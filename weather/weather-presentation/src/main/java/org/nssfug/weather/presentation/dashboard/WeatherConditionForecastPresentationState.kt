package org.nssfug.weather.presentation.dashboard

import org.nssfug.weather.presentation.model.WeatherConditionPresentationModel

sealed interface WeatherConditionForecastPresentationState {
    object Initial : WeatherConditionForecastPresentationState
    object Error : WeatherConditionForecastPresentationState
    object Loading : WeatherConditionForecastPresentationState

    data class Result(
        val items: List<WeatherConditionPresentationModel>
    ) : WeatherConditionForecastPresentationState
}