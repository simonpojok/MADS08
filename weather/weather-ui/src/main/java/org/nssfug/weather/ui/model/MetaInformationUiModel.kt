package org.nssfug.weather.ui.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class MetaInformationUiModel(
    @DrawableRes
    val iconResourceId: Int,
    @DrawableRes
    val backgroundImageId: Int,
    val description: String,
    @ColorRes
    val backgroundColor: Int
)