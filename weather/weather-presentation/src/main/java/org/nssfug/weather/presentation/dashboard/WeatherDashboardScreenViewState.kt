package org.nssfug.weather.presentation.dashboard

import org.nssfug.common.presentation.state.ViewState

data class WeatherDashboardScreenViewState(
    val weatherForecastState: WeatherConditionForecastPresentationState = WeatherConditionForecastPresentationState.Initial,
    val weatherConditionState: WeatherConditionPresentationState = WeatherConditionPresentationState.Initial,
    val userLocationState: UserLocationPresentationState = UserLocationPresentationState.NotKnown
) : ViewState