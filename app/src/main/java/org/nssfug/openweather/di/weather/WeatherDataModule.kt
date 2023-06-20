package org.nssfug.openweather.di.weather

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.nssfug.weather.datasource.LocalDataSource
import org.nssfug.weather.datasource.RemoteDataSource
import org.nssfug.weather.datasource.mapper.LocationDataToDomainMapper
import org.nssfug.weather.datasource.mapper.MetaInformationDataToDomainMapper
import org.nssfug.weather.datasource.mapper.TempMeasurementDataToDomainMapper
import org.nssfug.weather.datasource.mapper.WeatherConditionDataToDomainMapper
import org.nssfug.weather.datasource.repository.LocationCurrentWeatherConditionDataRepository
import org.nssfug.weather.datasource.repository.LocationWeatherForecastDataRepository
import org.nssfug.weather.domain.repository.LocationCurrentWeatherConditionRepository
import org.nssfug.weather.domain.repository.LocationWeatherForecastRepository

@Module
@InstallIn(SingletonComponent::class)
class WeatherDataModule {
    @Provides
    fun providesLocationDataToDomainMapper() = LocationDataToDomainMapper()

    @Provides
    fun providesMetaInformationDataToDomainMapper() = MetaInformationDataToDomainMapper()

    @Provides
    fun providesTempMeasurementDataToDomainMapper() = TempMeasurementDataToDomainMapper()

    @Provides
    fun providesWeatherConditionDataToDomainMapper(
        tempMeasurementDataToDomainMapper: TempMeasurementDataToDomainMapper,
        metaInformationDataToDomainMapper: MetaInformationDataToDomainMapper
    ) = WeatherConditionDataToDomainMapper(
        tempMeasurementDataToDomainMapper,
        metaInformationDataToDomainMapper
    )

    @Provides
    fun providesLocationWeatherForecastRepository(
        weatherConditionDataToDomainMapper: WeatherConditionDataToDomainMapper,
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): LocationWeatherForecastRepository = LocationWeatherForecastDataRepository(
        weatherConditionDataToDomainMapper, remoteDataSource, localDataSource
    )

    @Provides
    fun providesLocationCurrentWeatherConditionRepository(
        weatherConditionDataToDomainMapper: WeatherConditionDataToDomainMapper,
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): LocationCurrentWeatherConditionRepository = LocationCurrentWeatherConditionDataRepository(
        weatherConditionDataToDomainMapper,
        remoteDataSource,
        localDataSource
    )
}