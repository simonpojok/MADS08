package org.nssfug.weather.datasource.mapper

import org.nssfug.common.datasource.mapper.DomainToDataMapper
import org.nssfug.weather.datasource.model.LocationDataModel
import org.nssfug.weather.domain.model.LocationDomainModel

class LocationDomainToDataMapper : DomainToDataMapper<LocationDomainModel, LocationDataModel> {
    override fun toData(domain: LocationDomainModel) = LocationDataModel(
        longitude = domain.longitude,
        latitude = domain.latitude
    )
}