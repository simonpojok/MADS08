package org.nssfug.weather.datasource.mapper

import org.nssfug.common.datasource.mapper.DataToDomainMapper
import org.nssfug.weather.datasource.model.MetaInformationDataModel
import org.nssfug.weather.domain.model.MetaInformationDomainModel

class MetaInformationDataToDomainMapper :
    DataToDomainMapper<MetaInformationDataModel, MetaInformationDomainModel> {
    override fun toDomain(data: MetaInformationDataModel) = MetaInformationDomainModel(
        id = data.id,
        main = data.main,
        description = data.description,
        icon = data.icon
    )
}