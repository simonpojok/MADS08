package org.nssfug.weather.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.nssfug.common.ui.getState
import org.nssfug.weather.presentation.dashboard.WeatherConditionForecastPresentationState
import org.nssfug.weather.presentation.dashboard.WeatherDashboardScreenViewModel
import org.nssfug.weather.presentation.model.LocationPresentationModel
import org.nssfug.weather.ui.R
import org.nssfug.weather.ui.mapper.WeatherConditionPresentationToUiMapper
import org.nssfug.weather.ui.mapper.createWeatherConditionUiMapper
import org.nssfug.weather.ui.screens.components.TempElementIndicator
import org.nssfug.weather.ui.screens.components.TempStatisticIndicator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherDashboardScreen(
    viewModel: WeatherDashboardScreenViewModel = hiltViewModel(),
    weatherConditionUiMapper: WeatherConditionPresentationToUiMapper = createWeatherConditionUiMapper()
) {
    val dashboardViewState by viewModel.getState()

    LaunchedEffect(Unit, block = {
        viewModel.fetch5DaysWeatherForecast(LocationPresentationModel(longitude = 0.0, latitude = 0.0))
        viewModel.fetchLocationWeatherCondition(LocationPresentationModel(longitude = 0.0, latitude = 0.0))
    })

    Scaffold() { internalPadding ->
        Column(
            modifier = Modifier
                .background(colorResource(id = R.color.cloudy))
                .padding(internalPadding)
                .padding(bottom = 20.dp)
                .fillMaxSize(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.forest_cloudy),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.0f),
                contentScale = ContentScale.FillBounds
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                TempElementIndicator(temp = 16, description = "min")
                TempElementIndicator(temp = 16, description = "Current")
                TempElementIndicator(temp = 16, description = "max")
            }

            Divider(modifier = Modifier.fillMaxWidth())

            val (weatherForecastState) = dashboardViewState

            when (weatherForecastState) {
                is WeatherConditionForecastPresentationState.Result -> {
                    val weatherConditions = weatherForecastState.items.map(weatherConditionUiMapper::toUi)
                    weatherConditions.forEach { weatherCondition ->
                        TempStatisticIndicator(weatherCondition = weatherCondition)
                    }
                }
                else -> {}
            }
        }
    }
}