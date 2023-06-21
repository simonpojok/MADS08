package org.nssfug.weather.local.datasource.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "temp_measurement")
data class TempMeasurementEntity(
    val currentTemperature: Double,
    val minimumTemperature: Double,
    val maximumTemperature: Double,
    var weatherLocalId: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}