package org.nssfug.weather.local.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import org.nssfug.weather.local.datasource.dao.LocationEntityDao
import org.nssfug.weather.local.datasource.dao.MetaInformationEntityDao
import org.nssfug.weather.local.datasource.dao.TempMeasurementEntityDao
import org.nssfug.weather.local.datasource.dao.WeatherConditionEntityDao
import org.nssfug.weather.local.datasource.model.LocationEntity
import org.nssfug.weather.local.datasource.model.MetaInformationEntity
import org.nssfug.weather.local.datasource.model.TempMeasurementEntity
import org.nssfug.weather.local.datasource.model.WeatherConditionEntity

@Database(
    entities = [
        LocationEntity::class,
        MetaInformationEntity::class,
        TempMeasurementEntity::class,
        WeatherConditionEntity::class
    ], version = 1
)
abstract class WeatherConditionLocalDatabase : RoomDatabase() {
    abstract fun locationEntityDao(): LocationEntityDao
    abstract fun metaInformationEntityDao(): MetaInformationEntityDao
    abstract fun tempMeasurementEntityDao(): TempMeasurementEntityDao
    abstract fun weatherConditionEntityDao(): WeatherConditionEntityDao
}