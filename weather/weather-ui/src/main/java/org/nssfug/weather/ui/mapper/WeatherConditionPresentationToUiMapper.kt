package org.nssfug.weather.ui.mapper

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import org.nssfug.common.ui.mapper.PresentationToUiMapper
import org.nssfug.weather.presentation.model.WeatherConditionPresentationModel
import org.nssfug.weather.ui.MainWeatherContext
import org.nssfug.weather.ui.model.WeatherConditionUiModel
import java.lang.IllegalArgumentException

class WeatherConditionPresentationToUiMapper(
    private val metaInformationPresentationToUiMapper: MetaInformationPresentationToUiMapper,
    private val tempMeasurementPresentationToUiMapper: TempMeasurementPresentationToUiMapper
) : PresentationToUiMapper<WeatherConditionPresentationModel, WeatherConditionUiModel> {
    override fun toUi(presentation: WeatherConditionPresentationModel) = WeatherConditionUiModel(
        occurrenceDateTime = presentation.occurrenceDateTime,
        occurrenceTimeStamp = presentation.occurrenceTimeStamp,
        tempMeasurements = tempMeasurementPresentationToUiMapper.toUi(presentation.tempMeasurements),
        metaInformation = metaInformationPresentationToUiMapper.toUi(presentation.metaInformation)
    )
}

@Composable
fun createWeatherConditionUiMapper(): WeatherConditionPresentationToUiMapper =
    when (val mainContext = LocalContext.current) {
        is MainWeatherContext -> mainContext.weatherConditionPresentationToUiMapper

        else -> throw IllegalArgumentException("Context Not Found")
    }
