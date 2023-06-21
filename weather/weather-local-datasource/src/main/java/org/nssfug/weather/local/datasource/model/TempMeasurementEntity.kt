package org.nssfug.weather.local.datasource.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class TempMeasurementEntity(
    val currentTemperature: Double,
    val minimumTemperature: Double,
    val maximumTemperature: Double
)