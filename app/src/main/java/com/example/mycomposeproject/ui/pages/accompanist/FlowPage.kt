package com.example.mycomposeproject.ui.pages.accompanist

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun FlowPage() {
    val elements = arrayOf(
        "Apple",
        "Banana",
        "Cherry",
        "Watermelon",
        "Strawberries",
    )

    FlowRow(
        mainAxisAlignment = FlowMainAxisAlignment.Start,
        mainAxisSpacing = 10.dp,
        crossAxisAlignment = FlowCrossAxisAlignment.Start,
        crossAxisSpacing = 20.dp
    ) {
        repeat(5) {
            elements.forEach {
                Text(
                    text = "$it",
                    modifier = Modifier
                        .border(1.dp, Color.Green)
                        .padding(10.dp)
                )
            }
        }
    }
}