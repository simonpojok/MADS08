package org.nssfug.weather.local.datasource.mapper

import org.nssfug.common.local.datasource.mapper.DataToLocalMapper
import org.nssfug.weather.datasource.model.TempMeasurementDataModel
import org.nssfug.weather.local.datasource.model.TempMeasurementEntity
import kotlin.properties.Delegates

class TempMeasurementDataToEntityMapper: DataToLocalMapper<TempMeasurementDataModel, TempMeasurementEntity> {

    override fun toLocal(data: TempMeasurementDataModel) = TempMeasurementEntity(
        currentTemperature = data.currentTemperature,
        minimumTemperature = data.minimumTemperature,
        maximumTemperature = data.maximumTemperature,
    )
}