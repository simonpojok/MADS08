package org.nssfug.weather.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.nssfug.weather.presentation.dashboard.WeatherConditionPresentationState
import org.nssfug.weather.ui.mapper.WeatherConditionPresentationToUiMapper
import org.nssfug.weather.ui.mapper.createWeatherConditionUiMapper

@Composable
fun WeatherInformationHeader(
    modifier: Modifier = Modifier,
    weatherConditionState: WeatherConditionPresentationState,
    weatherConditionUiMapper: WeatherConditionPresentationToUiMapper = createWeatherConditionUiMapper(),
    onSaveWeatherConditionFavorite: () -> Unit = {},
    onViewFavoriteWeatherCondition: () -> Unit = {}
) {
    Box(modifier = modifier) {
        when (weatherConditionState) {
            WeatherConditionPresentationState.Loading -> {}
            is WeatherConditionPresentationState.Result -> {
                val weatherCondition =
                    weatherConditionUiMapper.toUi(weatherConditionState.weatherCondition)

                Image(
                    painter = painterResource(id = weatherCondition.metaInformation.backgroundImageId),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = weatherCondition.tempMeasurements.currentTemperature,
                        fontSize = 80.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = weatherCondition.metaInformation.description
                            .uppercase(),
                        fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.White
                    )
                }
            }

            WeatherConditionPresentationState.Error -> {}
            WeatherConditionPresentationState.Initial -> {}
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onSaveWeatherConditionFavorite) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            IconButton(onClick = onViewFavoriteWeatherCondition) {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}