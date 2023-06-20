package org.nssfug.openweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import org.nssfug.openweather.ui.theme.OpenWeatherTheme
import org.nssfug.weather.presentation.dashboard.WeatherDashboardScreenViewModel
import org.nssfug.weather.ui.screens.WeatherDashboardScreen
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenWeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeatherDashboardScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(viewModel: WeatherDashboardScreenViewModel = hiltViewModel()) {
    Text(
        text = "Hello !",
    )
    WeatherDashboardScreen()
}