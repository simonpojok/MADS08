package org.nssfug.weather.ui.model


data class WeatherConditionUiModel(
    val tempMeasurements: TempMeasurementUiModel,
    val metaInformation: MetaInformationUiModel,
    val date: String
)