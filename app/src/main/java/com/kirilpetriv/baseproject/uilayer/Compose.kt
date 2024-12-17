package com.kirilpetriv.baseproject.uilayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
internal fun Loading(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        LoadingIndicator(modifier = Modifier.size(100.dp))
    }
}

@Composable
internal fun Success(
    state: BaseScreenState.Success,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        state.data.imageStrings.map {
            it.toThumbnailUrl()
        }.let { images ->
            items(images) { url ->
                AsyncImage(
                    model = url,
                    contentDescription = "Car image"
                )
            }
        }
    }
}

@Composable
fun LoadingIndicator(
    modifier: Modifier = Modifier,
    strokeCap: StrokeCap = StrokeCap.Square,
    strokeWidth: Dp = ProgressIndicatorDefaults.CircularStrokeWidth,
    color: Color = MaterialTheme.colorScheme.primary,
) {
    CircularProgressIndicator(
        color = color,
        modifier = modifier,
        strokeCap = strokeCap,
        strokeWidth = strokeWidth,
    )
}