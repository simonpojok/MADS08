package org.nssfug.weather.domain.model

data class TempMeasurementDomainModel(
    val currentTemperature: Double,
    val minimumTemperature: Double,
    val maximumTemperature: Double
)