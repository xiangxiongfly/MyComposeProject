package com.example.mycomposeproject.ui.pages.other

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LifecyclePage() {
    var counter by remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()
    val updateCounter by rememberUpdatedState(counter)

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Counter: ${counter}")
        Row {
            Button(onClick = { counter-- }) {
                Text("-")
            }
            Button(onClick = { counter++ }) {
                Text("+")
            }
        }
        Button(onClick = {
            scope.launch {
                Log.e("TAG", "协程操作")
                counter = 3000
            }
        }) {
            Text("协程操作")
        }
        Text("监听最新状态：${updateCounter}")

        Divider()
        MySnapshotFlow()
        Divider()
        MyProduceState()
        Divider()
        MyDerivedStateOf()
    }

    SideEffect {
        Log.e("TAG", "hello 重组了")
    }

    DisposableEffect(Unit) {
        Log.e("TAG", "预处理")
        counter = 100

        onDispose {
            Log.e("TAG", "销毁处理")
        }
    }

    LaunchedEffect(Unit) {
        val ret = async {
            delay(2000L)
            Log.e("TAG", "异步处理")
            2000
        }
        counter = ret.await()
    }
}

@Composable
fun MySnapshotFlow() {
    var time by remember { mutableStateOf("${System.currentTimeMillis()}") }
    val flow = snapshotFlow { time }

    Button(onClick = {
        time = "${System.currentTimeMillis()}"
    }) {
        Text("更新")
    }

    LaunchedEffect(Unit) {
        flow.collect {
            Log.e("TAG", "snapshotFlow: ${it}")
        }
    }
}

data class Person(val name: String, val age: Int, val time: Long)

@Composable
fun MyProduceState() {
    var name by remember { mutableStateOf("小明") }
    var age by remember { mutableStateOf(18) }

    val personState by produceState(
        initialValue = Person(name, age, System.currentTimeMillis()),
        name,
        age
    ) {
        value = Person(name, age, System.currentTimeMillis())
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { name = "小红" }) {
            Text("修改name")
        }
        Button(onClick = { age = 19 }) {
            Text("修改age")
        }
        Text("produceState: ${personState}")
    }
}

@Composable
fun MyDerivedStateOf() {
    var postList by remember { mutableStateOf(listOf("a", "b", "c", "d", "e")) }
    var keyword by remember { mutableStateOf("") }
    val result by remember {
        derivedStateOf { postList.filter { it.contains(keyword, false) } }
    }
    Text("过滤：${result}")
    Button(onClick = { postList = listOf("1", "2", "3", "4", "5") }) {
        Text("List")
    }
    OutlinedTextField(value = keyword, onValueChange = { keyword = it }, label = { Text("请输入") })
}