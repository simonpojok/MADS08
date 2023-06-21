package org.nssfug.weather.local.datasource.mapper

import org.nssfug.common.datasource.model.LocationDataModel
import org.nssfug.common.local.datasource.mapper.LocalToDataMapper
import org.nssfug.weather.local.datasource.model.LocationEntity

class LocationEntityToDataMapper : LocalToDataMapper<LocationEntity, LocationDataModel> {
    override fun toData(localData: LocationEntity) = LocationDataModel(
        latitude = localData.latitude,
        longitude = localData.longitude
    )
}