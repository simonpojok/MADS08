package org.nssfug.weather.presentation.mappers

import org.nssfug.common.presentation.mapper.PresentationToDomainMapper
import org.nssfug.weather.domain.model.TempMeasurementDomainModel
import org.nssfug.weather.presentation.model.TempMeasurementPresentationModel

class TempMeasurementPresentationToDomainMapper :
    PresentationToDomainMapper<TempMeasurementPresentationModel, TempMeasurementDomainModel> {
    override fun toDomain(presentation: TempMeasurementPresentationModel) =
        TempMeasurementDomainModel(
            currentTemperature = presentation.currentTemperature.toDouble(),
            minimumTemperature = presentation.minimumTemperature.toDouble(),
            maximumTemperature = presentation.maximumTemperature.toDouble()
        )
}