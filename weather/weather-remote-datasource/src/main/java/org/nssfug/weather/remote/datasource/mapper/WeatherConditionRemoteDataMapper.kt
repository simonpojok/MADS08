package org.nssfug.weather.remote.datasource.mapper

import org.nssfug.common.remote.datasource.mapper.RemoteToDataMapper
import org.nssfug.weather.datasource.model.WeatherConditionDataModel
import org.nssfug.weather.remote.datasource.model.WeatherConditionRemoteModel

class WeatherConditionRemoteDataMapper(
    private val tempMeasurementRemoteToDataMapper: TempMeasurementRemoteToDataMapper,
    private val metaInformationRemoteToDataMapper: MetaInformationRemoteToDataMapper
) : RemoteToDataMapper<WeatherConditionRemoteModel, WeatherConditionDataModel> {


    override fun toData(remote: WeatherConditionRemoteModel) = WeatherConditionDataModel(
        occurrenceDateTime = remote.dt_txt,
        occurrenceTimeStamp = remote.dt,
        metaInformation = metaInformationRemoteToDataMapper.toData(remote.weather.first()),
        tempMeasurements = tempMeasurementRemoteToDataMapper.toData(remote.main)
    )
}