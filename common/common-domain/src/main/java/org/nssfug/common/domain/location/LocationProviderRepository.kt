package org.nssfug.common.domain.location

import org.nssfug.common.domain.location.model.LocationDomainModel

interface LocationProviderRepository {
    suspend fun getCurrentLocation(): LocationDomainModel
}