package org.nssfug.openweather.di.weather

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.nssfug.weather.ui.mapper.MetaInformationPresentationToUiMapper
import org.nssfug.weather.ui.mapper.TempMeasurementPresentationToUiMapper
import org.nssfug.weather.ui.mapper.WeatherConditionPresentationToUiMapper

@Module
@InstallIn(SingletonComponent::class)
class WeatherUiModule {
    @Provides
    fun providesMetaInformationPresentationToUiMapper() = MetaInformationPresentationToUiMapper()

    @Provides
    fun providesTempMeasurementPresentationToUiMapper(@ApplicationContext context: Context) =
        TempMeasurementPresentationToUiMapper(context.resources)

    @Provides
    fun providesWeatherConditionPresentationToUiMapper(
        metaInformationPresentationToUiMapper: MetaInformationPresentationToUiMapper,
        tempMeasurementPresentationToUiMapper: TempMeasurementPresentationToUiMapper
    ) = WeatherConditionPresentationToUiMapper(
        metaInformationPresentationToUiMapper,
        tempMeasurementPresentationToUiMapper
    )
}