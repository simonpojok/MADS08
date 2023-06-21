package org.nssfug.weather.presentation.dashboard

import org.nssfug.weather.presentation.model.LocationPresentationModel

sealed class UserLocationPresentationState {
    object NotKnown : UserLocationPresentationState()
    object Error : UserLocationPresentationState()
    data class Result(
        val locationDomainModel: LocationPresentationModel
    ) : UserLocationPresentationState()
}