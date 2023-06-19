package org.nssfug.weather.remote.datasource.model

data class MetaInformationRemoteModel(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)