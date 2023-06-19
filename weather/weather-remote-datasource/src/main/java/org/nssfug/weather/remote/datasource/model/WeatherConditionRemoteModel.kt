package org.nssfug.weather.remote.datasource.model

class WeatherConditionRemoteModel(
    val dt: Long?,
    val main: TempMeasurementRemoteModel,
    val weather: List<MetaInformationRemoteModel>,
    val dt_txt: String?
)