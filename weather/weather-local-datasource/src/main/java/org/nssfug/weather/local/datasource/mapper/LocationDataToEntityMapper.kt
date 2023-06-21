package org.nssfug.weather.local.datasource.mapper

import org.nssfug.common.local.datasource.mapper.DataToLocalMapper
import org.nssfug.weather.datasource.model.LocationDataModel
import org.nssfug.weather.local.datasource.model.LocationEntity

class LocationDataToEntityMapper : DataToLocalMapper<LocationDataModel, LocationEntity> {
    override fun toLocal(data: LocationDataModel) = LocationEntity(
        latitude = data.latitude,
        longitude = data.longitude
    )
}