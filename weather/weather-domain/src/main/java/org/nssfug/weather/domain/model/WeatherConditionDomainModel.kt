package org.nssfug.weather.domain.model

class WeatherConditionDomainModel(
    val occurrenceTimeStamp: Long?,
    val tempMeasurements: TempMeasurementDomainModel,
    val metaInformation: MetaInformationDomainModel,
    val occurrenceDateTime: String?
)