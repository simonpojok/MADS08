package org.nssfug.weather.ui.mapper

import android.icu.text.DateFormat
import android.icu.text.SimpleDateFormat
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import org.nssfug.common.ui.mapper.PresentationToUiMapper
import org.nssfug.weather.presentation.model.WeatherConditionPresentationModel
import org.nssfug.weather.ui.MainWeatherContext
import org.nssfug.weather.ui.model.WeatherConditionUiModel
import java.lang.IllegalArgumentException
import java.util.Calendar
import java.util.Locale

class WeatherConditionPresentationToUiMapper(
    private val metaInformationPresentationToUiMapper: MetaInformationPresentationToUiMapper,
    private val tempMeasurementPresentationToUiMapper: TempMeasurementPresentationToUiMapper
) : PresentationToUiMapper<WeatherConditionPresentationModel, WeatherConditionUiModel> {
    override fun toUi(presentation: WeatherConditionPresentationModel) = WeatherConditionUiModel(
        tempMeasurements = tempMeasurementPresentationToUiMapper.toUi(presentation.tempMeasurements),
        metaInformation = metaInformationPresentationToUiMapper.toUi(presentation.metaInformation),
        date = presentation.occurrenceDateTime?.getDay().orEmpty()
    )
}

@Composable
fun createWeatherConditionUiMapper(): WeatherConditionPresentationToUiMapper =
    when (val mainContext = LocalContext.current) {
        is MainWeatherContext -> mainContext.weatherConditionPresentationToUiMapper

        else -> throw IllegalArgumentException("Context Not Found")
    }

fun String.getDay(): String? {
    val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(this)
    return SimpleDateFormat("EEE", Locale.getDefault()).format(date)
}