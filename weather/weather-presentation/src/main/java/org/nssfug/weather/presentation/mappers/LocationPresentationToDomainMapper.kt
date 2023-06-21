package org.nssfug.weather.presentation.mappers

import org.nssfug.common.presentation.mapper.PresentationToDomainMapper
import org.nssfug.weather.domain.model.LocationDomainModel
import org.nssfug.weather.presentation.model.LocationPresentationModel

class LocationPresentationToDomainMapper :
    PresentationToDomainMapper<LocationPresentationModel, LocationDomainModel> {
    override fun toDomain(presentation: LocationPresentationModel) = LocationDomainModel(
        longitude = presentation.longitude,
        latitude = presentation.latitude
    )
}