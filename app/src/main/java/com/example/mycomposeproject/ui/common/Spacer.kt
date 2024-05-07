package com.example.mycomposeproject.ui.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun VerticalSpacer( vertical: Dp = 0.dp) {
    Spacer( modifier = Modifier.padding(vertical = vertical))
}

@Composable
fun HorizontalSpacer( horizontal: Dp = 0.dp) {
    Spacer( modifier = Modifier.padding(horizontal = horizontal))
}