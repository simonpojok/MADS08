package org.nssfug.weather.local.datasource.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import dagger.Provides
import org.nssfug.weather.local.datasource.model.MetaInformationEntity
import org.nssfug.weather.local.datasource.model.TempMeasurementEntity

@Entity(tableName = "weather_condition")
data class WeatherConditionEntity(
    val occurrenceTimeStamp: Long?,
    val tempMeasurements: TempMeasurementEntity,
    val metaInformation: MetaInformationEntity,
    val occurrenceDateTime: String?,
    val locationId: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}