package com.example.mycomposeproject.ui.pages.simple.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { }, shape = RoundedCornerShape(10.dp)) {
            Text("按钮")
        }

        Spacer(Modifier.height(10.dp))

        Button(onClick = { }) {
            Icon(
                imageVector = Icons.Filled.Done,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("确定")
        }
        Spacer(Modifier.height(10.dp))

        val interactionSource = remember { MutableInteractionSource() }
        val pressState = interactionSource.collectIsPressedAsState() // 是否按下
        val borderColor = if (pressState.value) Color.Red else Color.Green

        Button(
            onClick = { },
            border = BorderStroke(2.dp, borderColor),
            interactionSource = interactionSource
        ) {
            Text("按钮")
        }

        Spacer(Modifier.height(10.dp))

        IconButton(onClick = {}) {
            Icon(Icons.Filled.Favorite, contentDescription = null)
        }

        Spacer(Modifier.height(10.dp))

        FloatingActionButton(onClick = { }) {
            Icon(Icons.Filled.ArrowBack, null)
        }

        Spacer(Modifier.height(10.dp))
        ExtendedFloatingActionButton(
            text = { Text("hello world compose button") },
            icon = { Icon(Icons.Filled.Favorite, null) },
            onClick = { }
        )

    }
}

