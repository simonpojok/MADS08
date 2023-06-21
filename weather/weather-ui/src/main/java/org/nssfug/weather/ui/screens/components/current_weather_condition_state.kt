package org.nssfug.weather.ui.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.nssfug.weather.presentation.dashboard.WeatherConditionPresentationState
import org.nssfug.weather.ui.mapper.WeatherConditionPresentationToUiMapper
import org.nssfug.weather.ui.mapper.createWeatherConditionUiMapper

@Composable
fun CurrentWeatherConditionStateHandler(
    weatherConditionState: WeatherConditionPresentationState,
    weatherConditionUiMapper: WeatherConditionPresentationToUiMapper = createWeatherConditionUiMapper()
) {
    when (weatherConditionState) {
        is WeatherConditionPresentationState.Loading -> {}
        is WeatherConditionPresentationState.Initial -> {}
        is WeatherConditionPresentationState.Result -> {
            val weatherCondition = weatherConditionUiMapper.toUi(weatherConditionState.weatherCondition)

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                TempElementIndicator(temp = weatherCondition.tempMeasurements.minimumTemperature, description = "min")
                TempElementIndicator(temp = weatherCondition.tempMeasurements.currentTemperature, description = "Current")
                TempElementIndicator(temp = weatherCondition.tempMeasurements.maximumTemperature, description = "max")
            }
        }
        is WeatherConditionPresentationState.Error -> {}
    }
}