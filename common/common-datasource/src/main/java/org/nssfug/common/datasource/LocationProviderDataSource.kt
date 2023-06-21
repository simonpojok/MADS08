package org.nssfug.common.datasource

import org.nssfug.common.datasource.mapper.LocationToDomainMapper
import org.nssfug.common.domain.location.LocationProviderRepository
import org.nssfug.common.domain.location.model.LocationDomainModel

class LocationProviderDataSource(
    private val locationProviderLocalDataSource: LocationProviderLocalDataSource,
    private val locationToDomainMapper: LocationToDomainMapper
) : LocationProviderRepository {
    override suspend fun getCurrentLocation(): LocationDomainModel {
        val location = locationProviderLocalDataSource.getCurrentLocation()
        return locationToDomainMapper.toDomain(location)
    }
}