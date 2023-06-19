package org.nssfug.weather.remote.datasource.mapper

import org.nssfug.common.remote.datasource.mapper.DataToRemoteMapper
import org.nssfug.weather.datasource.model.LocationDataModel
import org.nssfug.weather.remote.datasource.model.LocationRemoteModel

class LocationDataToRemoteMapper : DataToRemoteMapper<LocationDataModel, LocationRemoteModel> {
    override fun toRemote(data: LocationDataModel) = LocationRemoteModel(
        lat = data.latitude,
        lon = data.longitude
    )
}