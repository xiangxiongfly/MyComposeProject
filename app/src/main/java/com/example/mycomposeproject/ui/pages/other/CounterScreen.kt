package com.example.mycomposeproject.ui.pages

import android.os.Bundle
import android.os.Parcelable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.android.parcel.Parcelize

// StatefulComposable
@Composable
fun CounterScreen() {
    var counter by remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        CounterComponent(
            counter = counter,
            onIncrement = { counter++ },
            onDecrement = {
                if (counter > 0) {
                    counter--
                }
            }
        )
        PersonScreen()
        PeopleScreen()
        CityScreen()
    }
}

// StatelessComposable
@Composable
fun CounterComponent(
    counter: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Counter:", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Text(
            "$counter",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Row {
            Button(onClick = { onDecrement() }, modifier = Modifier.weight(1F)) {
                Text("-")
            }
            Button(onClick = { onIncrement() }, modifier = Modifier.weight(1F)) {
                Text("+")
            }
        }
    }
}

@Parcelize
data class Person(val name: String, val age: Int) : Parcelable

@Composable
fun PersonScreen() {
    var person by rememberSaveable { mutableStateOf(Person("小白", 18)) }
    Button(onClick = { person = Person("小黑", 28) }) {
        Text(person.toString())
    }
}

data class People(val name: String, val age: Int)

// 有的数据结构可能无法添加Parcelable接口，比如定义在三方库的类等，此时可以通过自定义Saver为其实现保存和恢复的逻辑。只需要在调用rememberSavable时传入此Saver即可
object PersonSaver : Saver<People, Bundle> {
    override fun restore(value: Bundle): People {
        val name = value.getString("name") ?: ""
        val age = value.getInt("age")
        return People(name, age)
    }

    override fun SaverScope.save(value: People): Bundle {
        return Bundle().apply {
            putString("name", value.name)
            putInt("age", value.age)
        }
    }
}

@Composable
fun PeopleScreen() {
    var people by rememberSaveable(stateSaver = PersonSaver) { mutableStateOf(People("小红", 18)) }
    Button(onClick = { people = People("小绿", 28) }) {
        Text(people.toString())
    }
}

data class City(val name: String, val country: String)

// MapSaver
val CitySaver = run {
    val nameKey = "name"
    val countryKey = "country"
    mapSaver(
        save = { mapOf(nameKey to it.name, countryKey to it.country) },
        restore = { City(it[nameKey] as String, it[countryKey] as String) }
    )
}

// ListSaver
val CitySaver2 = listSaver<City, Any>(
    save = { listOf(it.name, it.country) },
    restore = { City(it[0] as String, it[1] as String) }
)

@Composable
fun CityScreen() {
    var city by rememberSaveable(stateSaver = CitySaver2) { mutableStateOf(City("北京", "中国")) }
    Button(onClick = { city = City("东京", "日本") }) {
        Text(city.toString())
    }
}
