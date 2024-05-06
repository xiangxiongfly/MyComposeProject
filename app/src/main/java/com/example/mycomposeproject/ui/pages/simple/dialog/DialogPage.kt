package com.example.mycomposeproject.ui.pages.simple.dialog

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Preview
@Composable
fun DialogPage() {
    val showAlertDialog = remember { mutableStateOf(false) }
    val showDialog = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { showAlertDialog.value = true }) {
            Text("显示AlertDialog")
        }
        MyAlertDialog(showAlertDialog)
        Button(onClick = { showDialog.value = true }) {
            Text("显示Dialog")
        }
        MyDialog(showDialog)
    }
}

@Composable
fun MyAlertDialog(showAlertDialog: MutableState<Boolean>) {
    if (showAlertDialog.value) {
        AlertDialog(
            onDismissRequest = { showAlertDialog.value = false },
            title = { Text("标题") },
            text = { Text("这是一些内容") },
            confirmButton = {
                TextButton(onClick = { showAlertDialog.value = false }) {
                    Text("同意")
                }
            },
            dismissButton = {
                TextButton(onClick = { showAlertDialog.value = false }) {
                    Text("取消")
                }
            }
        )
    }
}

@Composable
fun MyDialog(showDialog: MutableState<Boolean>) {
    if (showDialog.value) {
        Dialog(
            onDismissRequest = { showDialog.value = false },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        ) {
            Surface(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                color = Color.White,
                shape = RoundedCornerShape(10.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("标题", fontSize = 24.sp, modifier = Modifier.padding(vertical = 10.dp))
                    Text("这是一些内容", fontSize = 16.sp)
                    TextButton(onClick = { showDialog.value = false }) {
                        Text("确定", color = Color.Red)
                    }
                }
            }
        }
    }
}