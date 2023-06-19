package org.nssfug.weather.datasource.mapper

import org.nssfug.common.datasource.mapper.DataToDomainMapper
import org.nssfug.weather.datasource.model.WeatherConditionDataModel
import org.nssfug.weather.domain.model.WeatherConditionDomainModel

class WeatherConditionDataToDomainMapper(
    private val tempMeasurementDataToDomainMapper: TempMeasurementDataToDomainMapper,
    private val metaInformationDataToDomainMapper: MetaInformationDataToDomainMapper
) : DataToDomainMapper<WeatherConditionDataModel, WeatherConditionDomainModel> {
    override fun toDomain(data: WeatherConditionDataModel) = WeatherConditionDomainModel(
        metaInformation = metaInformationDataToDomainMapper.toDomain(data.metaInformation),
        occurrenceDateTime = data.occurrenceDateTime,
        occurrenceTimeStamp = data.occurrenceTimeStamp,
        tempMeasurements = tempMeasurementDataToDomainMapper.toDomain(data.tempMeasurements)
    )
}