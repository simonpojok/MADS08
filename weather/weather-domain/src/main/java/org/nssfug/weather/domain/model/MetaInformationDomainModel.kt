package org.nssfug.weather.domain.model

data class MetaInformationDomainModel(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)