package com.example.mycomposeproject.ui.pages.simple.selector

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun SelectorPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        MyCheckbox()

        Spacer(Modifier.height(10.dp))

        MyCheckbox2()

        Spacer(Modifier.height(10.dp))

        MyRadioButton()

        Spacer(Modifier.height(10.dp))

        MyTriStateCheckbox()

        Spacer(Modifier.height(10.dp))

        MySwitch()

        Spacer(Modifier.height(10.dp))

        MySlider()
    }
}

@Composable
fun MyCheckbox() {
    var checkedState by remember { mutableStateOf(false) }
    Checkbox(
        checked = checkedState,
        onCheckedChange = { checkedState = it },
        colors = CheckboxDefaults.colors(checkedColor = Color.Red),
    )
}


@Composable
fun MyCheckbox2() {
    val hobbyOptions = remember { mutableStateListOf(false, false, false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text("爱好： ")
        Text("足球")
        Checkbox(
            checked = hobbyOptions[0],
            onCheckedChange = { hobbyOptions[0] = it }
        )
        Text("篮球")
        Checkbox(
            checked = hobbyOptions[1],
            onCheckedChange = { hobbyOptions[1] = it }
        )
        Text("乒乓球")
        Checkbox(
            checked = hobbyOptions[2],
            onCheckedChange = { hobbyOptions[2] = it }
        )
    }
}

@Composable
fun MyRadioButton() {
    var sexOption by remember { mutableStateOf(0) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text("性别： ")
        Text("男")
        RadioButton(selected = sexOption == 0, onClick = { sexOption = 0 })
        Text("女")
        RadioButton(selected = sexOption == 1, onClick = { sexOption = 1 })
    }
}

@Composable
fun MyTriStateCheckbox() {
    // 子Checkbox状态
    val (state, onStateChange) = remember { mutableStateOf(true) }
    // 子Checkbox状态
    val (state2, onStateChange2) = remember { mutableStateOf(true) }
    // 父TriStateCheckbox状态
    val parentState = remember(state, state2) {
        if (state && state2) ToggleableState.On// 开
        else if (!state && !state2) ToggleableState.Off // 关
        else ToggleableState.Indeterminate // 不确定
    }
    val onParentClick = {
        val s = parentState != ToggleableState.On
        onStateChange(s)
        onStateChange2(s)
    }

    TriStateCheckbox(
        state = parentState,
        onClick = onParentClick,
        colors = CheckboxDefaults.colors(checkedColor = Color.Red)
    )
    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        Checkbox(checked = state, onCheckedChange = onStateChange)
        Checkbox(checked = state2, onCheckedChange = onStateChange2)
    }
}


@Composable
fun MySwitch() {
    var checkedState by remember { mutableStateOf(true) }
    Switch(
        checked = checkedState,
        onCheckedChange = { checkedState = it }
    )
}

@Composable
fun MySlider() {
    var sliderPosition by remember { mutableStateOf(0F) }
    val format = "%.1f"
    Text("${String.format(format, sliderPosition * 100)}%")
    Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
}