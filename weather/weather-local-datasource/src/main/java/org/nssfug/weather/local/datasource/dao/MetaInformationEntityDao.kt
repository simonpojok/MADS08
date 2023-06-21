package org.nssfug.weather.local.datasource.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.nssfug.weather.local.datasource.model.MetaInformationEntity

interface MetaInformationEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMetaInformationEntity(metaInfo: MetaInformationEntity)

    @Query("SELECT * FROM meta_info WHERE weatherId=:weatherConditionId")
    suspend fun getWeatherConditionMetaInfo(weatherConditionId: Int): MetaInformationEntity
}