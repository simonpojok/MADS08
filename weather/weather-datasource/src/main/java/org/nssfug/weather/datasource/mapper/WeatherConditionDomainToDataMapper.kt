package org.nssfug.weather.datasource.mapper

import org.nssfug.common.datasource.mapper.DomainToDataMapper
import org.nssfug.weather.datasource.model.WeatherConditionDataModel
import org.nssfug.weather.domain.model.WeatherConditionDomainModel

class WeatherConditionDomainToDataMapper(
    private val tempMeasurementDomainMapper: TempMeasurementDomainToDataMapper,
    private val metaInformationDomainMapper: MetaInformationDomainToDataMapper
) : DomainToDataMapper<WeatherConditionDomainModel, WeatherConditionDataModel> {
    override fun toData(domain: WeatherConditionDomainModel) = WeatherConditionDataModel(
        occurrenceDateTime = domain.occurrenceDateTime,
        occurrenceTimeStamp = domain.occurrenceTimeStamp,
        tempMeasurements = tempMeasurementDomainMapper.toData(domain.tempMeasurements),
        metaInformation = metaInformationDomainMapper.toData(domain.metaInformation)
    )
}