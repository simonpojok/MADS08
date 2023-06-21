package org.nssfug.weather.ui.mapper

import org.nssfug.common.ui.mapper.PresentationToUiMapper
import org.nssfug.weather.presentation.model.MetaInformationPresentationModel
import org.nssfug.weather.ui.R
import org.nssfug.weather.ui.model.MetaInformationUiModel

class MetaInformationPresentationToUiMapper: PresentationToUiMapper<MetaInformationPresentationModel, MetaInformationUiModel> {
    override fun toUi(presentation: MetaInformationPresentationModel) = when(presentation.icon) {
        "01d" -> MetaInformationUiModel(R.drawable.clear)
        "02d" -> MetaInformationUiModel(R.drawable.clear)
        "03d" -> MetaInformationUiModel(R.drawable.clear)
        "04d" -> MetaInformationUiModel(R.drawable.partlysunny)
        "09d" -> MetaInformationUiModel(R.drawable.partlysunny)
        "10d" -> MetaInformationUiModel(R.drawable.rain)
        "11d" -> MetaInformationUiModel(R.drawable.rain)
        else -> MetaInformationUiModel(R.drawable.clear)
    }
}