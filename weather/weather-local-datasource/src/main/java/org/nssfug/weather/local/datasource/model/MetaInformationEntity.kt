package org.nssfug.weather.local.datasource.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class MetaInformationEntity(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)