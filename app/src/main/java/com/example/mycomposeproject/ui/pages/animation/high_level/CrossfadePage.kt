package com.example.mycomposeproject.ui.pages.animation.high_level

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun CrossfadePage() {
    var currentState by remember { mutableStateOf("A") }
    Column {
        Crossfade(targetState = currentState) { state ->
            when (state) {
                "A" -> Text("hello world")
                "B" -> Text("hello compose")
            }

        }
        Button(onClick = { currentState = if (currentState == "A") "B" else "A" }) {
            Text("切换状态")
        }
    }
}