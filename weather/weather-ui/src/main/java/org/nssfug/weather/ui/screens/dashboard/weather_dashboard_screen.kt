package org.nssfug.weather.ui.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import org.nssfug.common.ui.getState
import org.nssfug.weather.presentation.dashboard.WeatherConditionForecastPresentationState
import org.nssfug.weather.presentation.dashboard.WeatherDashboardScreenViewModel
import org.nssfug.weather.ui.R
import org.nssfug.weather.ui.mapper.WeatherConditionPresentationToUiMapper
import org.nssfug.weather.ui.mapper.createWeatherConditionUiMapper
import org.nssfug.weather.ui.screens.components.CurrentWeatherConditionStateHandler
import org.nssfug.weather.ui.screens.components.TempStatisticIndicator
import org.nssfug.weather.ui.screens.components.WeatherInformationHeader

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun WeatherDashboardScreen(
    viewModel: WeatherDashboardScreenViewModel = hiltViewModel(),
    weatherConditionUiMapper: WeatherConditionPresentationToUiMapper = createWeatherConditionUiMapper(),
    navController: NavHostController
) {
    val dashboardViewState by viewModel.getState()
    val locationPermissions = rememberMultiplePermissionsState(
        permissions = listOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
    )

    LaunchedEffect(key1 = locationPermissions.allPermissionsGranted) {
        if (locationPermissions.allPermissionsGranted) {
            viewModel.onLoadWeatherConditionAction()
        } else {
            locationPermissions.launchMultiplePermissionRequest()
        }
    }

    val (weatherForecastState, weatherConditionState) = dashboardViewState


    Scaffold() { internalPadding ->
        Column(
            modifier = Modifier
                .background(colorResource(id = R.color.cloudy))
                .padding(internalPadding)
                .padding(bottom = 20.dp)
                .fillMaxSize(),
        ) {
            WeatherInformationHeader(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                weatherConditionState = weatherConditionState,
                onSaveWeatherConditionFavorite = viewModel::onMarkCurrentWeatherConditionFavorite,
                onViewFavoriteWeatherCondition = { navController.navigate("favorites") }
            )

            CurrentWeatherConditionStateHandler(weatherConditionState)

            Divider(modifier = Modifier.fillMaxWidth())

            when (weatherForecastState) {
                is WeatherConditionForecastPresentationState.Result -> {
                    val weatherConditions =
                        weatherForecastState.items.map(weatherConditionUiMapper::toUi)
                    weatherConditions.forEach { weatherCondition ->
                        TempStatisticIndicator(weatherCondition = weatherCondition)
                    }
                }

                else -> {}
            }
        }
    }
}