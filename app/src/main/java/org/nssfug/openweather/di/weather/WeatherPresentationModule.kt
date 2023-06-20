package org.nssfug.openweather.di.weather

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.nssfug.weather.presentation.mappers.MetaInformationDomainToPresentationMapper
import org.nssfug.weather.presentation.mappers.TempMeasurementDomainToPresentationMapper
import org.nssfug.weather.presentation.mappers.WeatherConditionDomainToPresentationMapper

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
}