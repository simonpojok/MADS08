package org.nssfug.openweather.di.weather

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.nssfug.weather.presentation.mappers.LocationDomainToPresentationMapper
import org.nssfug.weather.presentation.mappers.LocationPresentationToDomainMapper
import org.nssfug.weather.presentation.mappers.MetaInformationDomainToPresentationMapper
import org.nssfug.weather.presentation.mappers.MetaInformationPresentationToDomainMapper
import org.nssfug.weather.presentation.mappers.TempMeasurementDomainToPresentationMapper
import org.nssfug.weather.presentation.mappers.TempMeasurementPresentationToDomainMapper
import org.nssfug.weather.presentation.mappers.UserLocationPresentationStateResultToLocationDomainModelMapper
import org.nssfug.weather.presentation.mappers.WeatherConditionDomainToPresentationMapper
import org.nssfug.weather.presentation.mappers.WeatherConditionForecastPresentationStateToDomainModelMapper
import org.nssfug.weather.presentation.mappers.WeatherConditionPresentationStateToWeatherConditionMapper
import org.nssfug.weather.presentation.mappers.WeatherConditionPresentationToDomainMapper

@Module
@InstallIn(SingletonComponent::class)
class WeatherPresentationModule {

    @Provides
    fun providesMetaInformationDomainToPresentationMapper() =
        MetaInformationDomainToPresentationMapper()

    @Provides
    fun providesTempMeasurementDomainToPresentationMapper() =
        TempMeasurementDomainToPresentationMapper()

    @Provides
    fun providesWeatherConditionDomainToPresentationMapper(
        metaInformationDomainToPresentationMapper: MetaInformationDomainToPresentationMapper,
        tempMeasurementDomainToPresentationMapper: TempMeasurementDomainToPresentationMapper
    ) = WeatherConditionDomainToPresentationMapper(
        metaInformationDomainToPresentationMapper,
        tempMeasurementDomainToPresentationMapper
    )

    @Provides
    fun providesLocationPresentationToDomainMapper() = LocationPresentationToDomainMapper()

    @Provides
    fun providesUserLocationPresentationStateResultToLocationDomainModelMapper(
        locationPresentationToDomainMapper: LocationPresentationToDomainMapper
    ) = UserLocationPresentationStateResultToLocationDomainModelMapper(
        locationPresentationToDomainMapper
    )

    @Provides
    fun providesTempMeasurementPresentationToDomainMapper() =
        TempMeasurementPresentationToDomainMapper()

    @Provides
    fun providesMetaInformationPresentationToDomainMapper() =
        MetaInformationPresentationToDomainMapper()

    @Provides
    fun providesWeatherConditionPresentationToDomainMapper(
        metaInformationPresentationMapper: MetaInformationPresentationToDomainMapper,
        tempMeasurementPresentationMapper: TempMeasurementPresentationToDomainMapper
    ) = WeatherConditionPresentationToDomainMapper(
        metaInformationPresentationMapper,
        tempMeasurementPresentationMapper
    )

    @Provides
    fun providesWeatherConditionPresentationStateToWeatherConditionMapper(
        weatherConditionPresentationMapper: WeatherConditionPresentationToDomainMapper
    ) =
        WeatherConditionPresentationStateToWeatherConditionMapper(weatherConditionPresentationMapper)

    @Provides
    fun providesWeatherConditionForecastPresentationStateToDomainModelMapper(
        weatherConditionPresentationMapper: WeatherConditionPresentationToDomainMapper
    ) = WeatherConditionForecastPresentationStateToDomainModelMapper(
        weatherConditionPresentationMapper
    )

    @Provides
    fun providesLocationDomainToPresentationMapper() = LocationDomainToPresentationMapper()
}