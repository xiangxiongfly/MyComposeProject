package com.example.mycomposeproject.ui.pages.other

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun RecomposePage() {
    Log.e("TAG", "Scope-1 run")
    var counter by remember { mutableStateOf(0) }
    Column {
        Log.e("TAG", "Scope-2 run")
        Button(onClick = run {
            Log.e("TAG", "Button Scope")
            return@run {
                counter++
            }
        }) {
            Log.e("TAG", "Scope-4 run")
            Text("hello")
        }
        Text(run {
            Log.e("TAG", "Text run")
            return@run "$counter"
        })
        Button(onClick = run {
            Log.e("TAG", "Button2 Scope")
            return@run {

            }
        }) {
            Log.e("TAG", "Scope-5 run")
            Text("hello2")
        }
    }
}

