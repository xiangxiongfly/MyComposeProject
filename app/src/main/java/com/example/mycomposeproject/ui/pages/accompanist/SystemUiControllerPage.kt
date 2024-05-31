package com.example.mycomposeproject.ui.pages.accompanist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SystemUiControllerPage() {
    val systemUiController = rememberSystemUiController()
    val isLight = MaterialTheme.colors.isLight
    val colors = arrayOf(
        Color.Red,
        Color.Green,
        Color.Blue,
        Color.Black,
        Color.Gray
    )

    SideEffect {
        systemUiController.setSystemBarsColor(Color.Transparent)
    }

    Column(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxSize()
            .background(Color.White)
    ) {
        colors.forEach {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(it)
                    .clickable {
                        systemUiController.setSystemBarsColor(it)
                    }
            )
        }
    }
}