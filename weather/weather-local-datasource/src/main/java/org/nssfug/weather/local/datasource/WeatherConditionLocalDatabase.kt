package org.nssfug.weather.local.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import org.nssfug.weather.local.datasource.dao.LocationEntityDao
import org.nssfug.weather.local.datasource.model.LocationEntity

@Database(
    entities = [
        LocationEntity::class,
    ], version = 2
)
abstract class WeatherConditionLocalDatabase : RoomDatabase() {
    abstract fun locationEntityDao(): LocationEntityDao
}