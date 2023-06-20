package org.nssfug.weather.presentation.model

data class WeatherConditionPresentationModel(
    val occurrenceTimeStamp: Long?,
    val tempMeasurements: TempMeasurementPresentationModel,
    val metaInformation: MetaInformationPresentationModel,
    val occurrenceDateTime: String?
)