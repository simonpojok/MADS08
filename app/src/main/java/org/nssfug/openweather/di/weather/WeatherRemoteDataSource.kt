package org.nssfug.openweather.di.weather

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.nssfug.weather.datasource.RemoteDataSource
import org.nssfug.weather.remote.datasource.RemoteDataSourceImpl
import org.nssfug.weather.remote.datasource.RetrofitWeatherService
import org.nssfug.weather.remote.datasource.mapper.LocationDataToRemoteMapper
import org.nssfug.weather.remote.datasource.mapper.MetaInformationRemoteToDataMapper
import org.nssfug.weather.remote.datasource.mapper.TempMeasurementRemoteToDataMapper
import org.nssfug.weather.remote.datasource.mapper.WeatherConditionRemoteDataMapper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class WeatherRemoteDataSource {
    @Provides
    fun providesLocationDataToRemoteMapper() = LocationDataToRemoteMapper()

    @Provides
    fun providesMetaInformationRemoteToDataMapper() = MetaInformationRemoteToDataMapper()

    @Provides
    fun providesTempMeasurementRemoteToDataMapper() = TempMeasurementRemoteToDataMapper()

    @Provides
    fun providesWeatherConditionRemoteDataMapper(
        tempMeasurementRemoteToDataMapper: TempMeasurementRemoteToDataMapper,
        metaInformationRemoteToDataMapper: MetaInformationRemoteToDataMapper
    ) = WeatherConditionRemoteDataMapper(
        tempMeasurementRemoteToDataMapper,
        metaInformationRemoteToDataMapper
    )

    @Provides
    fun providesRemoteDataSource(
        weatherService: RetrofitWeatherService,
        locationDataToRemoteMapper: LocationDataToRemoteMapper,
        weatherConditionRemoteDataMapper: WeatherConditionRemoteDataMapper
    ): RemoteDataSource = RemoteDataSourceImpl(
        weatherService,
        locationDataToRemoteMapper,
        weatherConditionRemoteDataMapper
    )

    @Provides
    fun providesRetrofitWeatherService(retrofit: Retrofit): RetrofitWeatherService =
        retrofit.create(RetrofitWeatherService::class.java)
}