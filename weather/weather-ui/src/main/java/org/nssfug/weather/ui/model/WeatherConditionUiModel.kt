package org.nssfug.weather.ui.model


data class WeatherConditionUiModel(
    val occurrenceTimeStamp: Long?,
    val tempMeasurements: TempMeasurementUiModel,
    val metaInformation: MetaInformationUiModel,
    val occurrenceDateTime: String?
)