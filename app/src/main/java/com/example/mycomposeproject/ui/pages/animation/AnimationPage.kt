package com.example.mycomposeproject.ui.pages.animation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun MyAnimationPage(
    onClickAnimatedVisibility: () -> Unit,
    onClickAnimatedContent: () -> Unit,
    onClickCrossfade: () -> Unit,
    onClickAnimateXXXAsState: () -> Unit,
    onClickTransition: () -> Unit,
    onClickInfiniteTransition: () -> Unit,
    onClickAnimatablePage: () -> Unit,
    onClickAnimationPage: () -> Unit,
    onClickSpringPage: () -> Unit,
    onClickTweenPage: () -> Unit,
) {
    Column {
        Text("高级别动画：")
        Button(onClick = onClickAnimatedVisibility) {
            Text("AnimatedVisibility")
        }
        Button(onClick = onClickAnimatedContent) {
            Text("AnimatedContent")
        }
        Button(onClick = onClickCrossfade) {
            Text("Crossfade")
        }
        Text("低级别动画：")
        Button(onClick = onClickAnimateXXXAsState) {
            Text("AnimateXXXAsState")
        }
        Button(onClick = onClickTransition) {
            Text("Transition")
        }
        Button(onClick = onClickInfiniteTransition) {
            Text("InfiniteTransition")
        }
        Button(onClick = onClickAnimatablePage) {
            Text("Animatable")
        }
        Button(onClick = onClickAnimationPage) {
            Text("Animation")
        }
        Text("AnimationSpec:")
        Button(onClick = onClickSpringPage) {
            Text("spring阻尼动画")
        }
        Button(onClick = onClickTweenPage) {
            Text("tween补间动画")
        }
    }
}