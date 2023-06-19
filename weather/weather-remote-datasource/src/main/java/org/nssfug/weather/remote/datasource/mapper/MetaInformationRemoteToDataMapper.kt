package org.nssfug.weather.remote.datasource.mapper

import org.nssfug.common.remote.datasource.mapper.RemoteToDataMapper
import org.nssfug.weather.datasource.model.MetaInformationDataModel
import org.nssfug.weather.remote.datasource.model.MetaInformationRemoteModel

class MetaInformationRemoteToDataMapper :
    RemoteToDataMapper<MetaInformationRemoteModel, MetaInformationDataModel> {

    override fun toData(remote: MetaInformationRemoteModel) = MetaInformationDataModel(
        id = remote.id,
        main = remote.main,
        description = remote.description,
        icon = remote.icon
    )
}