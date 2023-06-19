package org.nssfug.weather.domain.usecase

import kotlinx.coroutines.CoroutineScope
import org.nssfug.common.domain.CoroutineContextProvider
import org.nssfug.common.domain.usecase.BackgroundExecuteUseCase
import org.nssfug.common.domain.usecase.BaseUseCase
import org.nssfug.weather.domain.model.LocationDomainModel
import org.nssfug.weather.domain.model.WeatherConditionDomainModel
import org.nssfug.weather.domain.repository.LocationCurrentWeatherConditionRepository

interface GetCurrentWeatherConditionUseCase :
    BaseUseCase<LocationDomainModel, WeatherConditionDomainModel>

class GetCurrentWeatherConditionUseCaseImpl(
    private val coroutineContextProvider: CoroutineContextProvider,
    private val locationCurrentWeatherConditionRepository: LocationCurrentWeatherConditionRepository
) : GetCurrentWeatherConditionUseCase,
    BackgroundExecuteUseCase<LocationDomainModel, WeatherConditionDomainModel>(
        coroutineContextProvider
    ) {
    override suspend fun executeInBackground(
        request: LocationDomainModel,
        coroutineScope: CoroutineScope
    ) = locationCurrentWeatherConditionRepository.getCurrentWeatherCondition(
        latitude = request.latitude,
        longitude = request.longitude
    )
}