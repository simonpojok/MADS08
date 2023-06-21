package org.nssfug.weather.local.datasource.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location")
data class LocationEntity(
    val longitude: Double,
    val latitude: Double,
    var weatherConditionData: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}