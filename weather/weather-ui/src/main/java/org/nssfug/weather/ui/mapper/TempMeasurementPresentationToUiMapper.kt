package org.nssfug.weather.ui.mapper

import android.content.res.Resources
import org.nssfug.common.ui.mapper.PresentationToUiMapper
import org.nssfug.weather.presentation.model.TempMeasurementPresentationModel
import org.nssfug.weather.ui.R
import org.nssfug.weather.ui.model.TempMeasurementUiModel

class TempMeasurementPresentationToUiMapper(
    private val resources: Resources
): PresentationToUiMapper<TempMeasurementPresentationModel, TempMeasurementUiModel> {
    override fun toUi(presentation: TempMeasurementPresentationModel) = TempMeasurementUiModel(
        currentTemperature = resources.getString(R.string.temp_indicator_value, presentation.currentTemperature.toString()),
        maximumTemperature = resources.getString(R.string.temp_indicator_value, presentation.maximumTemperature.toString()),
        minimumTemperature = resources.getString(R.string.temp_indicator_value, presentation.minimumTemperature.toString())
    )
}