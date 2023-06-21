package org.nssfug.weather.local.datasource.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meta_info")
data class MetaInformationEntity(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
    val weatherId: Int
) {
    @PrimaryKey(autoGenerate = true)
    var localId: Int = 0
}