package org.nssfug.weather.presentation.mappers

import org.nssfug.common.presentation.mapper.PresentationToDomainMapper
import org.nssfug.weather.domain.model.MetaInformationDomainModel
import org.nssfug.weather.presentation.model.MetaInformationPresentationModel

class MetaInformationPresentationToDomainMapper :
    PresentationToDomainMapper<MetaInformationPresentationModel, MetaInformationDomainModel> {
    override fun toDomain(presentation: MetaInformationPresentationModel) =
        MetaInformationDomainModel(
            id = presentation.id,
            icon = presentation.icon,
            description = presentation.description,
            main = presentation.main
        )
}