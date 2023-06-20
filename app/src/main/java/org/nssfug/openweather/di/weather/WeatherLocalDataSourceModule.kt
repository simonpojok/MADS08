package org.nssfug.openweather.di.weather

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.nssfug.weather.datasource.LocalDataSource
import org.nssfug.weather.local.datasource.WeatherLocalDataSource

@Module
@InstallIn(SingletonComponent::class)
class WeatherLocalDataSourceModule {
    @Provides
    fun providesWeatherLocalDataSource(): LocalDataSource = WeatherLocalDataSource()
}