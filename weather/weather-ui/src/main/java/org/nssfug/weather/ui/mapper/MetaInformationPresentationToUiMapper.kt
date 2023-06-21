package org.nssfug.weather.ui.mapper

import org.nssfug.common.ui.mapper.PresentationToUiMapper
import org.nssfug.weather.presentation.model.MetaInformationPresentationModel
import org.nssfug.weather.ui.R
import org.nssfug.weather.ui.model.MetaInformationUiModel

class MetaInformationPresentationToUiMapper :
    PresentationToUiMapper<MetaInformationPresentationModel, MetaInformationUiModel> {
    override fun toUi(presentation: MetaInformationPresentationModel) = when (presentation.icon) {
        "01d" -> MetaInformationUiModel(
            iconResourceId = R.drawable.clear,
            backgroundImageId = R.drawable.forest_sunny,
            description = presentation.main
        )

        "02d" -> MetaInformationUiModel(
            iconResourceId = R.drawable.clear,
            backgroundImageId = R.drawable.forest_sunny,
            description = presentation.main
        )

        "03d" -> MetaInformationUiModel(
            iconResourceId = R.drawable.clear,
            backgroundImageId = R.drawable.forest_sunny,
            description = presentation.main
        )

        "04d" -> MetaInformationUiModel(
            iconResourceId = R.drawable.partlysunny,
            backgroundImageId = R.drawable.forest_cloudy,
            description = presentation.main
        )

        "09d" -> MetaInformationUiModel(
            iconResourceId = R.drawable.partlysunny,
            backgroundImageId = R.drawable.forest_cloudy,
            description = presentation.main
        )

        "10d" -> MetaInformationUiModel(
            iconResourceId = R.drawable.rain,
            backgroundImageId = R.drawable.forest_cloudy,
            description = presentation.main
        )

        "11d" -> MetaInformationUiModel(
            iconResourceId = R.drawable.rain,
            backgroundImageId = R.drawable.forest_rainy,
            description = presentation.main
        )

        else -> MetaInformationUiModel(
            iconResourceId = R.drawable.rain,
            backgroundImageId = R.drawable.forest_rainy,
            description = presentation.main
        )
    }
}