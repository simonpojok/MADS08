package org.nssfug.openweather.di.common

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.nssfug.common.datasource.LocationProviderDataSource
import org.nssfug.common.datasource.LocationProviderLocalDataSource
import org.nssfug.common.datasource.mapper.LocationToDomainMapper
import org.nssfug.common.domain.location.LocationProviderRepository

@Module
@InstallIn(SingletonComponent::class)
class CommonDataModule {
    @Provides
    fun providesLocationToDomainMapper() = LocationToDomainMapper()

    @Provides
    fun providesLocationProviderRepository(
        locationProviderLocalDataSource: LocationProviderLocalDataSource,
        locationToDomainMapper: LocationToDomainMapper
    ): LocationProviderRepository =
        LocationProviderDataSource(locationProviderLocalDataSource, locationToDomainMapper)
}