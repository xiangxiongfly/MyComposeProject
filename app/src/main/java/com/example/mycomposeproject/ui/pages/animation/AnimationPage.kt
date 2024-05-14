package com.example.mycomposeproject.ui.pages.animation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
    onClickKeyframesPage: () -> Unit,
    onClickRepeatablePage: () -> Unit,
    onClickSnapPage: () -> Unit,
    onClickShimmerPage: () -> Unit,
    onClickFavButtonPage: () -> Unit,
    onClickSwitchPage: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
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
        Button(onClick = onClickKeyframesPage) {
            Text("keyframes关键帧动画")
        }
        Button(onClick = onClickRepeatablePage) {
            Text("repeatable关键帧动画")
        }
        Button(onClick = onClickSnapPage) {
            Text("snap快闪动画")
        }
        Text("案例：")
        Button(onClick = onClickShimmerPage) {
            Text("骨架屏动画")
        }
        Button(onClick = onClickFavButtonPage) {
            Text("收藏按钮动画")
        }
        Button(onClick = onClickSwitchPage) {
            Text("选中动画")
        }
    }
}