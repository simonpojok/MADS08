package org.nssfug.common.domain.location

import kotlinx.coroutines.CoroutineScope
import org.nssfug.common.domain.CoroutineContextProvider
import org.nssfug.common.domain.location.model.LocationDomainModel
import org.nssfug.common.domain.usecase.BackgroundExecuteUseCase
import org.nssfug.common.domain.usecase.BaseUseCase

interface GetCurrentLocationUseCase : BaseUseCase<Unit, LocationDomainModel>

class GetCurrentLocationUseCaseImpl(
    private val coroutineContextProvider: CoroutineContextProvider,
    private val locationProviderRepository: LocationProviderRepository
) : GetCurrentLocationUseCase,
    BackgroundExecuteUseCase<Unit, LocationDomainModel>(coroutineContextProvider) {
    override suspend fun executeInBackground(
        request: Unit,
        coroutineScope: CoroutineScope
    ) = locationProviderRepository.getCurrentLocation()
}