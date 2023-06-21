package org.nssfug.weather.presentation.dashboard

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.nssfug.common.presentation.BaseViewModel
import org.nssfug.common.presentation.location.LocationTracker
import org.nssfug.common.presentation.usecase.UseCaseExecutorProvider
import org.nssfug.weather.domain.model.LocationDomainModel
import org.nssfug.weather.domain.usecase.GetCurrentWeatherConditionUseCase
import org.nssfug.weather.domain.usecase.GetDailyWeatherForecastUseCase
import org.nssfug.weather.presentation.mappers.WeatherConditionDomainToPresentationMapper
import org.nssfug.weather.presentation.model.LocationPresentationModel
import javax.inject.Inject

@HiltViewModel
class WeatherDashboardScreenViewModel @Inject constructor(
    private val getDailyWeatherForecastUseCase: GetDailyWeatherForecastUseCase,
    private val getCurrentWeatherConditionUseCase: GetCurrentWeatherConditionUseCase,
    private val weatherConditionDomainMapper: WeatherConditionDomainToPresentationMapper,
    private val locationTracker: LocationTracker,
    useCaseExecutorProvider: UseCaseExecutorProvider
) : BaseViewModel<WeatherDashboardScreenViewState>(useCaseExecutorProvider) {

    override fun initialState() = WeatherDashboardScreenViewState()

    fun fetch5DaysWeatherForecast(location: LocationPresentationModel) {
        updateState { lastState ->
            lastState.copy(weatherForecastState = WeatherConditionForecastPresentationState.Loading)
        }

        useCaseExecutor.execute(
            useCase = getDailyWeatherForecastUseCase,
            value = LocationDomainModel(
                latitude = location.latitude,
                longitude = location.longitude
            ),
            callback = { weatherConditionForecasts ->
                val weatherForecasts = WeatherConditionForecastPresentationState.Result(
                    items = weatherConditionForecasts.map(
                        weatherConditionDomainMapper::toPresentation
                    )
                )

                updateState { lastState ->
                    lastState.copy(weatherForecastState = weatherForecasts)
                }
            },
            onError = { error ->
                updateState { lastState ->
                    lastState.copy(weatherForecastState = WeatherConditionForecastPresentationState.Error)
                }
            }
        )
    }

    fun fetchLocationWeatherCondition(location: LocationPresentationModel) {
        updateState { lastState ->
            lastState.copy(weatherConditionState = WeatherConditionPresentationState.Loading)
        }

        useCaseExecutor.execute(
            useCase = getCurrentWeatherConditionUseCase,
            value = LocationDomainModel(
                latitude = location.latitude,
                longitude = location.longitude
            ),
            callback = { weatherCondition ->
                updateState { lastState ->
                    lastState.copy(
                        weatherConditionState = WeatherConditionPresentationState.Result(
                            weatherCondition = weatherConditionDomainMapper.toPresentation(
                                weatherCondition
                            )
                        )
                    )
                }
            },
            onError = { error ->
                updateState { lastState ->
                    lastState.copy(weatherConditionState = WeatherConditionPresentationState.Error)
                }
            }
        )
    }

//    TODO: UseCase to query location needs to be create
    fun getCurrentLocation() {
        viewModelScope.launch {
            val location = locationTracker.getCurrentLocation()
            fetch5DaysWeatherForecast(
                LocationPresentationModel(
                    latitude = location?.latitude ?: 0.0,
                    longitude = location?.longitude ?: 0.0
                )
            )
            fetchLocationWeatherCondition(
                LocationPresentationModel(
                    latitude = location?.latitude ?: 0.0,
                    longitude = location?.longitude ?: 0.0
                )
            )
        }
    }
}