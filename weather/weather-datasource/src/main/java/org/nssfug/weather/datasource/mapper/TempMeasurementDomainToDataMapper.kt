package org.nssfug.weather.datasource.mapper

import org.nssfug.common.datasource.mapper.DomainToDataMapper
import org.nssfug.weather.datasource.model.TempMeasurementDataModel
import org.nssfug.weather.domain.model.TempMeasurementDomainModel

class TempMeasurementDomainToDataMapper :
    DomainToDataMapper<TempMeasurementDomainModel, TempMeasurementDataModel> {
    override fun toData(domain: TempMeasurementDomainModel) = TempMeasurementDataModel(
        currentTemperature = domain.currentTemperature,
        minimumTemperature = domain.minimumTemperature,
        maximumTemperature = domain.maximumTemperature
    )
}