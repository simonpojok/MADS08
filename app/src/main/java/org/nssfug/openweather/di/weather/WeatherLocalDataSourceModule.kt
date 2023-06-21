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
import org.nssfug.weather.local.datasource.dao.MetaInformationEntityDao
import org.nssfug.weather.local.datasource.dao.TempMeasurementEntityDao
import org.nssfug.weather.local.datasource.dao.WeatherConditionEntityDao
import org.nssfug.weather.local.datasource.mapper.LocationEntityToDataMapper
import org.nssfug.weather.local.datasource.mapper.MetaInformationEntityToDataMapper
import org.nssfug.weather.local.datasource.mapper.TempMeasurementEntityToDataMapper
import org.nssfug.weather.local.datasource.mapper.WeatherConditionEntityToDataMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class WeatherLocalDataSourceModule {
    @Provides
    fun providesWeatherLocalDataSource(): LocalDataSource = WeatherLocalDataSource()

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
    fun providesMetaInformationEntityDao(db: WeatherConditionLocalDatabase): MetaInformationEntityDao =
        db.metaInformationEntityDao()

    @Provides
    fun providesTempMeasurementEntityDao(db: WeatherConditionLocalDatabase): TempMeasurementEntityDao =
        db.tempMeasurementEntityDao()

    @Provides
    fun providesWeatherConditionEntityDao(db: WeatherConditionLocalDatabase): WeatherConditionEntityDao =
        db.weatherConditionEntityDao()
}