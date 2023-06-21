package org.nssfug.weather.local.datasource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.nssfug.weather.local.datasource.model.WeatherConditionEntity

@Dao
interface WeatherConditionEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherCondition(weatherCondition: WeatherConditionEntity)

    @Query("SELECT * FROM weather_condition WHERE locationId=:locationId")
    suspend fun getLocationWeatherCondition(locationId: Int): WeatherConditionEntity?
}