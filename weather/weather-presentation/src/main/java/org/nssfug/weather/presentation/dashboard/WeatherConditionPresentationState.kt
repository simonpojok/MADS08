package org.nssfug.weather.presentation.dashboard

import org.nssfug.weather.presentation.model.WeatherConditionPresentationModel


sealed interface WeatherConditionPresentationState {
    object Initial : WeatherConditionPresentationState
    object Error : WeatherConditionPresentationState
    object Loading : WeatherConditionPresentationState

    data class Result(
        val weatherCondition: WeatherConditionPresentationModel
    ) : WeatherConditionPresentationState
}