package org.nssfug.openweather.di.weather

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.nssfug.common.domain.CoroutineContextProvider
import org.nssfug.weather.domain.repository.LocationCurrentWeatherConditionRepository
import org.nssfug.weather.domain.repository.LocationWeatherForecastRepository
import org.nssfug.weather.domain.usecase.GetCurrentWeatherConditionUseCase
import org.nssfug.weather.domain.usecase.GetCurrentWeatherConditionUseCaseImpl
import org.nssfug.weather.domain.usecase.GetDailyWeatherForecastUseCase
import org.nssfug.weather.domain.usecase.GetDailyWeatherForecastUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
class WeatherDomainModule {
    @Provides
    fun providesGetCurrentWeatherConditionUseCase(
        coroutineContextProvider: CoroutineContextProvider,
        locationCurrentWeatherConditionRepository: LocationCurrentWeatherConditionRepository
    ): GetCurrentWeatherConditionUseCase = GetCurrentWeatherConditionUseCaseImpl(
        coroutineContextProvider, locationCurrentWeatherConditionRepository
    )

    @Provides
    fun providesGetDailyWeatherForecastUseCase(
        coroutineContextProvider: CoroutineContextProvider,
        locationWeatherForecastRepository: LocationWeatherForecastRepository
    ): GetDailyWeatherForecastUseCase = GetDailyWeatherForecastUseCaseImpl(
        coroutineContextProvider, locationWeatherForecastRepository
    )
}