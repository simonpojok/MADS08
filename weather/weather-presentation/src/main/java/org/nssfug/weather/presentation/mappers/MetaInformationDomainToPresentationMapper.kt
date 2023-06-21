package org.nssfug.weather.presentation.mappers

import org.nssfug.common.presentation.mapper.DomainToPresentationMapper
import org.nssfug.weather.domain.model.LocationDomainModel
import org.nssfug.weather.domain.model.MetaInformationDomainModel
import org.nssfug.weather.presentation.model.MetaInformationPresentationModel

class MetaInformationDomainToPresentationMapper :
    DomainToPresentationMapper<MetaInformationDomainModel, MetaInformationPresentationModel> {
    override fun toPresentation(domain: MetaInformationDomainModel): MetaInformationPresentationModel =
        MetaInformationPresentationModel(
            id = domain.id,
            main = domain.main,
            description = domain.description,
            icon = domain.icon
        )

}