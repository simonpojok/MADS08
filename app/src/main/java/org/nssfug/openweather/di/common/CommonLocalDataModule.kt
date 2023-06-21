package org.nssfug.openweather.di.common

import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.nssfug.common.datasource.LocationProviderLocalDataSource
import org.nssfug.common.local.datasource.location.DefaultLocationProviderRepository


@Module
@InstallIn(SingletonComponent::class)
class CommonLocalDataModule {
    @Provides
    fun providesLocationProviderLocalDataSource(
        fusedLocationProviderClient: FusedLocationProviderClient,
        application: Application
    ): LocationProviderLocalDataSource = DefaultLocationProviderRepository(
        fusedLocationProviderClient, application
    )
}