package org.nssfug.weather.ui.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.nssfug.weather.ui.R

@Composable
fun TempElementIndicator(
    temp: Int,
    description: String
) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(
                R.string.temp_indicator_value,
                temp.toString(),
            ),
            color = Color.White
        )
        Text(text = description, color = Color.White)
    }
}

@Composable
@Preview()
fun TempElementIndicatorPreview() {
    TempElementIndicator(temp = 16, description = "min")
}