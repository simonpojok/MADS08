package org.nssfug.weather.local.datasource.mapper

import org.nssfug.common.local.datasource.mapper.DataToLocalMapper
import org.nssfug.weather.datasource.model.WeatherConditionDataModel
import org.nssfug.weather.local.datasource.model.WeatherConditionEntity
import kotlin.properties.Delegates

class WeatherConditionDataToEntityMapper(
    private val tempMeasurementDataMapper: TempMeasurementDataToEntityMapper,
    private val metaInformationDataToEntityMapper: MetaInformationDataToEntityMapper
) : DataToLocalMapper<WeatherConditionDataModel, WeatherConditionEntity> {

    override fun toLocal(data: WeatherConditionDataModel) = WeatherConditionEntity(
        occurrenceDateTime = data.occurrenceDateTime,
        occurrenceTimeStamp = data.occurrenceTimeStamp,
        tempMeasurements = tempMeasurementDataMapper.toLocal(data.tempMeasurements),
        metaInformation = metaInformationDataToEntityMapper.toLocal(data.metaInformation)
    )
}