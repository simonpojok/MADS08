package org.nssfug.weather.remote.datasource.mapper

import org.nssfug.common.remote.datasource.mapper.RemoteToDataMapper
import org.nssfug.weather.datasource.model.TempMeasurementDataModel
import org.nssfug.weather.remote.datasource.model.TempMeasurementRemoteModel

class TempMeasurementRemoteToDataMapper :
    RemoteToDataMapper<TempMeasurementRemoteModel, TempMeasurementDataModel> {

    override fun toData(remote: TempMeasurementRemoteModel) = TempMeasurementDataModel(
        currentTemperature = remote.temp,
        minimumTemperature = remote.temp_min,
        maximumTemperature = remote.temp_max
    )
}