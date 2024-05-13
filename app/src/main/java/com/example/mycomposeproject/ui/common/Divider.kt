package com.example.mycomposeproject.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalDivider(thickness: Dp = 1.dp, verticalPadding: Dp = 10.dp) {
    Divider(modifier = Modifier.padding(vertical = verticalPadding), thickness = thickness)
}

