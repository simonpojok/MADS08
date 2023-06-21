package org.nssfug.weather.local.datasource.mapper

import org.nssfug.common.local.datasource.mapper.LocalToDataMapper
import org.nssfug.weather.datasource.model.TempMeasurementDataModel
import org.nssfug.weather.local.datasource.model.TempMeasurementEntity

class TempMeasurementEntityToDataMapper: LocalToDataMapper<TempMeasurementEntity, TempMeasurementDataModel> {
    override fun toData(localData: TempMeasurementEntity) = TempMeasurementDataModel(
        minimumTemperature = localData.minimumTemperature,
        maximumTemperature = localData.maximumTemperature,
        currentTemperature = localData.currentTemperature
    )
}