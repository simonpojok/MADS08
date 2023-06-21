package org.nssfug.common.datasource.mapper

import org.nssfug.common.datasource.model.LocationDataModel
import org.nssfug.common.domain.location.model.LocationDomainModel

class LocationToDomainMapper : DataToDomainMapper<LocationDataModel, LocationDomainModel> {
    override fun toDomain(data: LocationDataModel) = LocationDomainModel(
        latitude = data.latitude,
        longitude = data.longitude
    )
}