package org.nssfug.weather.presentation.mappers

import org.nssfug.common.presentation.mapper.DomainToPresentationMapper
import org.nssfug.weather.domain.model.LocationDomainModel
import org.nssfug.weather.presentation.model.LocationPresentationModel

class LocationDomainToPresentationMapper :
    DomainToPresentationMapper<LocationDomainModel, LocationPresentationModel> {
    override fun toPresentation(domain: LocationDomainModel): LocationPresentationModel = LocationPresentationModel(
        longitude = domain.longitude,
        latitude = domain.latitude
    )
}