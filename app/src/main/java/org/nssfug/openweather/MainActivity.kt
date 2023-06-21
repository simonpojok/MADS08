package org.nssfug.openweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import org.nssfug.openweather.ui.theme.OpenWeatherTheme
import org.nssfug.weather.presentation.dashboard.WeatherDashboardScreenViewModel
import org.nssfug.weather.ui.MainWeatherContext
import org.nssfug.weather.ui.mapper.MetaInformationPresentationToUiMapper
import org.nssfug.weather.ui.mapper.TempMeasurementPresentationToUiMapper
import org.nssfug.weather.ui.mapper.WeatherConditionPresentationToUiMapper
import org.nssfug.weather.ui.screens.dashboard.WeatherDashboardScreen
import org.nssfug.weather.ui.screens.favorites.FavoritesScreen
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity(), MainWeatherContext {
    @Inject
    override lateinit var weatherConditionPresentationToUiMapper: WeatherConditionPresentationToUiMapper

    @Inject
    override lateinit var metaInformationPresentationToUiMapper: MetaInformationPresentationToUiMapper

    @Inject
    override lateinit var tempMeasurementPresentationToUiMapper: TempMeasurementPresentationToUiMapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            OpenWeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") { WeatherDashboardScreen(navController = navController) }
                        composable("favorites") { FavoritesScreen(navController = navController) }
                    }
                }
            }
        }
    }
}