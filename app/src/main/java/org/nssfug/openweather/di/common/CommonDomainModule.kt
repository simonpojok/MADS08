package org.nssfug.openweather.di.common

import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.nssfug.common.datasource.LocationProviderDataSource
import org.nssfug.common.domain.CoroutineContextProvider
import org.nssfug.common.domain.DispatchersCoroutineContextProvider
import org.nssfug.common.domain.location.GetCurrentLocationUseCase
import org.nssfug.common.domain.location.GetCurrentLocationUseCaseImpl
import org.nssfug.common.domain.location.LocationProviderRepository
import org.nssfug.common.domain.usecase.UseCaseExecutor
import org.nssfug.common.presentation.usecase.UseCaseExecutorProvider

@Module
@InstallIn(SingletonComponent::class)
class CommonDomainModule {
    @Provides
    @Reusable
    fun provideCoroutineContextProvider(): CoroutineContextProvider =
        DispatchersCoroutineContextProvider()

    @Provides
    @Reusable
    fun providesUseCaseExecutorProvider(): UseCaseExecutorProvider =
        { coroutineScope -> UseCaseExecutor(coroutineScope) }

    @Provides
    fun providesGetCurrentLocationUseCase(
        coroutineContextProvider: CoroutineContextProvider,
        locationProviderRepository: LocationProviderRepository
    ): GetCurrentLocationUseCase = GetCurrentLocationUseCaseImpl(
        coroutineContextProvider,
        locationProviderRepository
    )
}