package org.nssfug.weather.local.datasource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.nssfug.weather.local.datasource.model.LocationEntity

@Dao
interface LocationEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(location: LocationEntity)

    @Query("SELECT * FROM location")
    suspend fun getLocations(): List<LocationEntity>

    @Query("SELECT * FROM location ORDER BY id DESC LIMIT 1")
    suspend fun getLatestSavedLocation(): LocationEntity
}