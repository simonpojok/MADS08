package org.nssfug.weather.presentation.mappers

import org.nssfug.common.presentation.mapper.DomainToPresentationMapper
import org.nssfug.weather.domain.model.WeatherConditionDomainModel
import org.nssfug.weather.presentation.model.WeatherConditionPresentationModel

class WeatherConditionDomainToPresentationMapper(
    private val metaInformationDomainToPresentationMapper: MetaInformationDomainToPresentationMapper,
    private val tempMeasurementDomainToPresentationMapper: TempMeasurementDomainToPresentationMapper
) : DomainToPresentationMapper<WeatherConditionDomainModel, WeatherConditionPresentationModel> {
    override fun toPresentation(domain: WeatherConditionDomainModel) =
        WeatherConditionPresentationModel(
            occurrenceTimeStamp = domain.occurrenceTimeStamp,
            occurrenceDateTime = domain.occurrenceDateTime,
            metaInformation = metaInformationDomainToPresentationMapper.toPresentation(domain.metaInformation),
            tempMeasurements = tempMeasurementDomainToPresentationMapper.toPresentation(domain.tempMeasurements)
        )
}