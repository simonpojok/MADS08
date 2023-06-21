package org.nssfug.weather.local.datasource.mapper

import org.nssfug.common.local.datasource.mapper.LocalToDataMapper
import org.nssfug.weather.datasource.model.MetaInformationDataModel
import org.nssfug.weather.local.datasource.model.MetaInformationEntity

class MetaInformationEntityToDataMapper :
    LocalToDataMapper<MetaInformationEntity, MetaInformationDataModel> {
    override fun toData(localData: MetaInformationEntity) = MetaInformationDataModel(
        main = localData.main,
        icon = localData.icon,
        description = localData.description,
        id = localData.id
    )
}