package com.example.mycomposeproject.ui.pages.animation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun AnimationPage(onClickAnimatedVisibility: () -> Unit, onClickAnimatedContent: () -> Unit) {
    Column {
        Button(onClick = onClickAnimatedVisibility) {
            Text("AnimatedVisibility")
        }
        Button(onClick = onClickAnimatedContent) {
            Text("AnimatedContent")
        }
    }
}