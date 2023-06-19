package org.nssfug.weather.datasource.mapper

import org.nssfug.common.datasource.mapper.DataToDomainMapper
import org.nssfug.weather.datasource.model.TempMeasurementDataModel
import org.nssfug.weather.domain.model.TempMeasurementDomainModel

class TempMeasurementDataToDomainMapper :
    DataToDomainMapper<TempMeasurementDataModel, TempMeasurementDomainModel> {
    override fun toDomain(data: TempMeasurementDataModel) = TempMeasurementDomainModel(
        currentTemperature = data.currentTemperature,
        minimumTemperature = data.minimumTemperature,
        maximumTemperature = data.maximumTemperature
    )
}