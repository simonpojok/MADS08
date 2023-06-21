package org.nssfug.weather.datasource.mapper

import org.nssfug.common.datasource.mapper.DomainToDataMapper
import org.nssfug.weather.datasource.model.MetaInformationDataModel
import org.nssfug.weather.domain.model.MetaInformationDomainModel

class MetaInformationDomainToDataMapper :
    DomainToDataMapper<MetaInformationDomainModel, MetaInformationDataModel> {
    override fun toData(domain: MetaInformationDomainModel) = MetaInformationDataModel(
        id = domain.id,
        main = domain.main,
        description = domain.description,
        icon = domain.icon
    )
}