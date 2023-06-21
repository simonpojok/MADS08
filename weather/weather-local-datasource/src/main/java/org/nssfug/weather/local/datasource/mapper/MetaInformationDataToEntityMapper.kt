package org.nssfug.weather.local.datasource.mapper

import org.nssfug.common.local.datasource.mapper.DataToLocalMapper
import org.nssfug.weather.datasource.model.MetaInformationDataModel
import org.nssfug.weather.local.datasource.model.MetaInformationEntity
import kotlin.properties.Delegates

class MetaInformationDataToEntityMapper :
    DataToLocalMapper<MetaInformationDataModel, MetaInformationEntity> {

    override fun toLocal(data: MetaInformationDataModel) = MetaInformationEntity(
        icon = data.icon,
        id = data.id,
        description = data.description,
        main = data.main
    )
}