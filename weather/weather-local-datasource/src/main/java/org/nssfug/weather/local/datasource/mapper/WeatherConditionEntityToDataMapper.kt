package org.nssfug.weather.local.datasource.mapper

import org.nssfug.common.local.datasource.mapper.LocalToDataMapper
import org.nssfug.weather.datasource.model.WeatherConditionDataModel
import org.nssfug.weather.local.datasource.model.WeatherConditionEntity

class WeatherConditionEntityToDataMapper(
    private val metaInformationEntityMapper: MetaInformationEntityToDataMapper,
    private val tempMeasurementEntityMapper: TempMeasurementEntityToDataMapper
) : LocalToDataMapper<WeatherConditionEntity, WeatherConditionDataModel> {
    override fun toData(localData: WeatherConditionEntity) = WeatherConditionDataModel(
        metaInformation = metaInformationEntityMapper.toData(localData.metaInformation),
        tempMeasurements = tempMeasurementEntityMapper.toData(localData.tempMeasurements),
        occurrenceTimeStamp = localData.occurrenceTimeStamp,
        occurrenceDateTime = localData.occurrenceDateTime
    )
}