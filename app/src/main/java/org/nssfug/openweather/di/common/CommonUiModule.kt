package org.nssfug.openweather.di.common

import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.nssfug.common.local.datasource.location.DefaultLocationProviderRepository
import org.nssfug.common.domain.location.LocationProviderRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CommonUiModule {
    @Provides
    @Singleton
    fun providesFusedLocationProviderClient(
        application: Application
    ): FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(application)
}