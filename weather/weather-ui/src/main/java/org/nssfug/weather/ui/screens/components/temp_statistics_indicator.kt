package org.nssfug.weather.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.nssfug.weather.ui.R

@Composable
fun TempStatisticIndicator() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Text(text = "Tuesday", color = Color.White, fontSize = 16.sp)
        Image(
            painter = painterResource(id = R.drawable.clear),
            contentDescription = null,
            modifier = Modifier.size(16.dp),
            contentScale = ContentScale.FillBounds,
        )
        Text(
            text = stringResource(R.string.temp_indicator_value, "20"),
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

@Preview
@Composable
fun TempStatisticIndicatorPreview() {
    TempStatisticIndicator()
}