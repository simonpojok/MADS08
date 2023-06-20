package org.nssfug.weather.domain.usecase

import kotlinx.coroutines.CoroutineScope
import org.nssfug.common.domain.CoroutineContextProvider
import org.nssfug.common.domain.usecase.BackgroundExecuteUseCase
import org.nssfug.common.domain.usecase.BaseUseCase
import org.nssfug.weather.domain.model.WeatherConditionDomainModel
import org.nssfug.weather.domain.model.LocationDomainModel
import org.nssfug.weather.domain.repository.LocationWeatherForecastRepository

interface GetDailyWeatherForecastUseCase :
    BaseUseCase<LocationDomainModel, List<WeatherConditionDomainModel>>

class GetDailyWeatherForecastUseCaseImpl(
    private val coroutineContextProvider: CoroutineContextProvider,
    private val locationWeatherForecastRepository: LocationWeatherForecastRepository
) : GetDailyWeatherForecastUseCase,
    BackgroundExecuteUseCase<LocationDomainModel, List<WeatherConditionDomainModel>>(
        coroutineContextProvider
    ) {
    override suspend fun executeInBackground(
        request: LocationDomainModel,
        coroutineScope: CoroutineScope
    ) = locationWeatherForecastRepository.getLocationDailyWeatherConditions(
        longitude = request.longitude,
        latitude = request.latitude
    ).map { weatherCondition ->
        weatherCondition.copy(
            occurrenceDateTime = weatherCondition.occurrenceDateTime?.split(" ")?.first(),
        )
    }.groupBy { weatherCondition -> weatherCondition.occurrenceDateTime }
        .map { (_, weatherCondition) ->
            weatherCondition.sortedBy { it.occurrenceTimeStamp }
                .first()
        }
}