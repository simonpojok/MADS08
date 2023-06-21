package org.nssfug.openweather.di.weather

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.nssfug.weather.datasource.LocalDataSource
import org.nssfug.weather.local.datasource.WeatherConditionLocalDatabase
import org.nssfug.weather.local.datasource.WeatherLocalDataSource
import org.nssfug.weather.local.datasource.dao.LocationEntityDao
import org.nssfug.weather.local.datasource.mapper.FavoriteWeatherConditionDataToLocalMapper
import org.nssfug.weather.local.datasource.mapper.LocationDataToEntityMapper
import org.nssfug.weather.local.datasource.mapper.LocationEntityToDataMapper
import org.nssfug.weather.local.datasource.mapper.MetaInformationDataToEntityMapper
import org.nssfug.weather.local.datasource.mapper.MetaInformationEntityToDataMapper
import org.nssfug.weather.local.datasource.mapper.TempMeasurementDataToEntityMapper
import org.nssfug.weather.local.datasource.mapper.TempMeasurementEntityToDataMapper
import org.nssfug.weather.local.datasource.mapper.WeatherConditionDataToEntityMapper
import org.nssfug.weather.local.datasource.mapper.WeatherConditionEntityToDataMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class WeatherLocalDataSourceModule {
    @Provides
    fun providesWeatherLocalDataSource(
        locationEntityDao: LocationEntityDao,
        favoriteWeatherConditionDataToLocalMapper: FavoriteWeatherConditionDataToLocalMapper,
        weatherConditionDataToEntityMapper: WeatherConditionDataToEntityMapper,
        locationDataToEntityMapper: LocationDataToEntityMapper,
        weatherConditionEntityMapper: WeatherConditionEntityToDataMapper
    ): LocalDataSource =
        WeatherLocalDataSource(
            locationEntityDao,
            favoriteWeatherConditionDataToLocalMapper,
            weatherConditionDataToEntityMapper,
            locationDataToEntityMapper,
            weatherConditionEntityMapper
        )

    @Provides
    fun providesMetaInformationEntityToDataMapper() = MetaInformationEntityToDataMapper()

    @Provides
    fun providesTempMeasurementEntityToDataMapper() = TempMeasurementEntityToDataMapper()

    @Provides
    fun providesWeatherConditionEntityToDataMapper(
        metaInformationEntityMapper: MetaInformationEntityToDataMapper,
        tempMeasurementEntityMapper: TempMeasurementEntityToDataMapper
    ) = WeatherConditionEntityToDataMapper(metaInformationEntityMapper, tempMeasurementEntityMapper)

    @Provides
    fun providesLocationEntityToDataMapper() = LocationEntityToDataMapper()

    @Provides
    @Singleton
    fun providesWeatherConditionLocalDatabase(@ApplicationContext applicationContext: Context): WeatherConditionLocalDatabase =
        Room.databaseBuilder(
            applicationContext,
            WeatherConditionLocalDatabase::class.java, "database-name"
        ).build()

    @Provides
    fun providesLocationEntityDao(db: WeatherConditionLocalDatabase): LocationEntityDao =
        db.locationEntityDao()

    @Provides
    fun providesLocationDataToEntityMapper() = LocationDataToEntityMapper()

    @Provides
    fun providesMetaInformationDataToEntityMapper() = MetaInformationDataToEntityMapper()

    @Provides
    fun providesTempMeasurementDataToEntityMapper() = TempMeasurementDataToEntityMapper()

    @Provides
    fun providesFavoriteWeatherConditionDataToLocalMapper(
        locationDataToEntityMapper: LocationDataToEntityMapper,
        weatherConditionDataToEntityMapper: WeatherConditionDataToEntityMapper
    ) = FavoriteWeatherConditionDataToLocalMapper(
        locationDataToEntityMapper,
        weatherConditionDataToEntityMapper
    )
}