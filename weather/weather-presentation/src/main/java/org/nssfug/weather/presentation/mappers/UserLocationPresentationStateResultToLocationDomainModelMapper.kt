package org.nssfug.weather.presentation.mappers

import org.nssfug.common.presentation.mapper.PresentationToDomainMapper
import org.nssfug.weather.domain.model.LocationDomainModel
import org.nssfug.weather.presentation.dashboard.UserLocationPresentationState

class UserLocationPresentationStateResultToLocationDomainModelMapper(
    private val locationPresentationToDomainMapper: LocationPresentationToDomainMapper
) :
    PresentationToDomainMapper<UserLocationPresentationState.Result, LocationDomainModel> {
    override fun toDomain(presentation: UserLocationPresentationState.Result) =
        locationPresentationToDomainMapper
            .toDomain(presentation.locationDomainModel)
}