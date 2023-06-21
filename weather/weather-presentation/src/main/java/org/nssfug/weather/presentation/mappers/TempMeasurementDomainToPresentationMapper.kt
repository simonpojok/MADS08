package org.nssfug.weather.presentation.mappers

import org.nssfug.common.presentation.mapper.DomainToPresentationMapper
import org.nssfug.weather.domain.model.TempMeasurementDomainModel
import org.nssfug.weather.presentation.model.TempMeasurementPresentationModel

class TempMeasurementDomainToPresentationMapper :
    DomainToPresentationMapper<TempMeasurementDomainModel, TempMeasurementPresentationModel> {
    override fun toPresentation(domain: TempMeasurementDomainModel) =
        TempMeasurementPresentationModel(
            currentTemperature = domain.currentTemperature.toInt(),
            minimumTemperature = domain.minimumTemperature.toInt(),
            maximumTemperature = domain.maximumTemperature.toInt()
        )
}