package org.nssfug.weather.datasource.model

class WeatherConditionDataModel(
    val occurrenceTimeStamp: Long?,
    val tempMeasurements: TempMeasurementDataModel,
    val metaInformation: MetaInformationDataModel,
    val occurrenceDateTime: String?
)