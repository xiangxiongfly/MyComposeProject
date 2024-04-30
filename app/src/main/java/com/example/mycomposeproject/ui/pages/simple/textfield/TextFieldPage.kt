package com.example.mycomposeproject.ui.pages.simple.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun TextFieldPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        var name by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

//        TextField(value = name, onValueChange = { name = it }, label = { Text("用户名") })
//        TextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("密码") },
//            visualTransformation = PasswordVisualTransformation()
//        )

//        TextField(
//            value = name,
//            onValueChange = { name = it },
//            label = { Text("用户名") },
//            leadingIcon = { Icon(Icons.Filled.AccountBox, null) }
//        )
//        TextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("密码") },
//            trailingIcon = {
//                IconButton(onClick = { }) {
//                    Icon(Icons.Filled.Face, null)
//                }
//            },
//            visualTransformation = PasswordVisualTransformation()
//        )


        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("用户名") },
            leadingIcon = { Icon(Icons.Filled.AccountBox, null) }
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("密码") },
            trailingIcon = {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Face, null)
                }
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Divider(modifier = Modifier.padding(vertical = 10.dp))

        val text = remember { mutableStateOf("hello") }
        BasicTextField(
            value = text.value,
            onValueChange = { text.value = it },
            decorationBox = { innerTextField ->
                Column {
                    innerTextField()
                    Divider(
                        thickness = 2.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Blue)
                    )
                }
            }
        )

        Divider(modifier = Modifier.padding(vertical = 10.dp))

        var searchText by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color(0xFFFF0000)),
            contentAlignment = Alignment.Center
        ) {
            BasicTextField(
                value = searchText,
                onValueChange = { searchText = it },
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .background(Color.White, CircleShape)
                    .height(30.dp)
                    .fillMaxWidth(),
                decorationBox = { innerTextField ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                        Box(
                            modifier = Modifier
                                .weight(1F)
                                .padding(horizontal = 5.dp),
                            contentAlignment = Alignment.CenterStart,
                        ) {
                            if (searchText.isEmpty()) {
                                Text("请输入点东西看看", style = TextStyle(color = Color(0, 0, 0, 128)))
                            }
                            innerTextField()
                        }
                        if (searchText.isNotEmpty()) {
                            IconButton(
                                onClick = { searchText = "" },
                                modifier = Modifier.size(16.dp)
                            ) {
                                Icon(imageVector = Icons.Filled.Close, contentDescription = null)
                            }
                        }
                    }
                }
            )
        }
    }

}
