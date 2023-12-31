package org.nssfug.weather.presentation.dashboard

import dagger.hilt.android.lifecycle.HiltViewModel
import org.nssfug.common.domain.location.GetCurrentLocationUseCase
import org.nssfug.common.presentation.BaseViewModel
import org.nssfug.common.presentation.usecase.UseCaseExecutorProvider
import org.nssfug.weather.domain.model.FavoriteWeatherConditionDomainModel
import org.nssfug.weather.domain.model.LocationDomainModel
import org.nssfug.weather.domain.usecase.GetCurrentWeatherConditionUseCase
import org.nssfug.weather.domain.usecase.GetDailyWeatherForecastUseCase
import org.nssfug.weather.domain.usecase.SaveFavoriteWeatherConditionUseCase
import org.nssfug.weather.presentation.mappers.LocationDomainToPresentationMapper
import org.nssfug.weather.presentation.mappers.UserLocationPresentationStateResultToLocationDomainModelMapper
import org.nssfug.weather.presentation.mappers.WeatherConditionDomainToPresentationMapper
import org.nssfug.weather.presentation.mappers.WeatherConditionForecastPresentationStateToDomainModelMapper
import org.nssfug.weather.presentation.mappers.WeatherConditionPresentationStateToWeatherConditionMapper
import javax.inject.Inject

@HiltViewModel
class WeatherDashboardScreenViewModel @Inject constructor(
    private val getDailyWeatherForecastUseCase: GetDailyWeatherForecastUseCase,
    private val getCurrentWeatherConditionUseCase: GetCurrentWeatherConditionUseCase,
    private val weatherConditionDomainMapper: WeatherConditionDomainToPresentationMapper,
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase,
    private val saveFavoriteWeatherConditionUseCase: SaveFavoriteWeatherConditionUseCase,
    private val userLocationPresentationStateMapper: UserLocationPresentationStateResultToLocationDomainModelMapper,
    private val weatherConditionPresentationStateMapper: WeatherConditionPresentationStateToWeatherConditionMapper,
    private val weatherConditionForecastPresentationStateMapper: WeatherConditionForecastPresentationStateToDomainModelMapper,
    private val locationPresentationMapper: LocationDomainToPresentationMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider
) : BaseViewModel<WeatherDashboardScreenViewState>(useCaseExecutorProvider) {

    override fun initialState() = WeatherDashboardScreenViewState()

    private fun fetch5DaysWeatherForecast(location: LocationDomainModel) {
        updateState { lastState ->
            lastState.copy(weatherForecastState = WeatherConditionForecastPresentationState.Loading)
        }

        useCaseExecutor.execute(
            useCase = getDailyWeatherForecastUseCase,
            value = location,
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

    private fun fetchLocationWeatherCondition(location: LocationDomainModel) {
        updateState { lastState ->
            lastState.copy(weatherConditionState = WeatherConditionPresentationState.Loading)
        }

        useCaseExecutor.execute(
            useCase = getCurrentWeatherConditionUseCase,
            value = location,
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

    fun onLoadWeatherConditionAction() {
        useCaseExecutor.execute(
            useCase = getCurrentLocationUseCase,
            callback = { locationDomainModel ->
                val actualLocation = LocationDomainModel(
                    longitude = locationDomainModel.longitude,
                    latitude = locationDomainModel.latitude
                )
                updateState { lastState ->
                    lastState.copy(
                        userLocationState = UserLocationPresentationState.Result(locationPresentationMapper.toPresentation(actualLocation))
                    )
                }

                fetch5DaysWeatherForecast(actualLocation)
                fetchLocationWeatherCondition(actualLocation)
            }
        )
    }

    fun onMarkCurrentWeatherConditionFavorite() {
        val userLocation = when (val userLocationState = currentViewState().userLocationState) {
            is UserLocationPresentationState.Result -> userLocationState
            else -> null
        }

        val currentWeatherCondition =
            when (val weatherCondition = currentViewState().weatherConditionState) {
                is WeatherConditionPresentationState.Result -> weatherCondition
                else -> null
            }

        val weatherForecast = when (val weatherForecast = currentViewState().weatherForecastState) {
            is WeatherConditionForecastPresentationState.Result -> weatherForecast
            else -> null
        }

        if (userLocation == null || currentWeatherCondition == null || weatherForecast == null) {
            return
        }


        useCaseExecutor.execute(
            useCase = saveFavoriteWeatherConditionUseCase,
            value = FavoriteWeatherConditionDomainModel(
                location = userLocationPresentationStateMapper.toDomain(userLocation),
                currentWeatherCondition = weatherConditionPresentationStateMapper.toDomain(
                    currentWeatherCondition
                ),
                locationWeatherForecast = weatherConditionForecastPresentationStateMapper.toDomain(
                    weatherForecast
                )
            ),
            callback = {},
            onError = { errors ->
                println(errors)
            }
        )
    }
}