package org.nssfug.weather.local.datasource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.nssfug.weather.local.datasource.model.TempMeasurementEntity

@Dao
interface TempMeasurementEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTempMeasurementEntity(tempMeasurement: TempMeasurementEntity): TempMeasurementEntity

    @Query("SELECT * FROM temp_measurement WHERE weatherLocalId=:weatherConditionId")
    suspend fun getWeatherConditionTempMeasurement(weatherConditionId: Int): TempMeasurementEntity
}