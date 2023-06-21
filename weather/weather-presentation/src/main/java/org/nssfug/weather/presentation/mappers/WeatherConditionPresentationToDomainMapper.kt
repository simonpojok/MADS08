package org.nssfug.weather.presentation.mappers

import org.nssfug.common.presentation.mapper.PresentationToDomainMapper
import org.nssfug.weather.domain.model.WeatherConditionDomainModel
import org.nssfug.weather.presentation.model.WeatherConditionPresentationModel

class WeatherConditionPresentationToDomainMapper(
    private val metaInformationPresentationMapper: MetaInformationPresentationToDomainMapper,
    private val tempMeasurementPresentationMapper: TempMeasurementPresentationToDomainMapper
): PresentationToDomainMapper<WeatherConditionPresentationModel, WeatherConditionDomainModel> {
    override fun toDomain(presentation: WeatherConditionPresentationModel) = WeatherConditionDomainModel(
        occurrenceTimeStamp = presentation.occurrenceTimeStamp,
        occurrenceDateTime = presentation.occurrenceDateTime,
        metaInformation = metaInformationPresentationMapper.toDomain(presentation.metaInformation),
        tempMeasurements = tempMeasurementPresentationMapper.toDomain(presentation.tempMeasurements)
    )
}