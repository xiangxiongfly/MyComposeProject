package com.example.mycomposeproject.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycomposeproject.ui.pages.animation.AnimationPage
import com.example.mycomposeproject.ui.pages.animation.high_level.AnimatedContentPage
import com.example.mycomposeproject.ui.pages.animation.high_level.AnimatedVisibilityPage
import com.example.mycomposeproject.ui.pages.layout.ColumnRowPage
import com.example.mycomposeproject.ui.pages.layout.ConstraintLayoutPage
import com.example.mycomposeproject.ui.pages.layout.SurfacePage
import com.example.mycomposeproject.ui.pages.other.LifecyclePage
import com.example.mycomposeproject.ui.pages.other.RecomposePage
import com.example.mycomposeproject.ui.pages.simple.button.ButtonPage
import com.example.mycomposeproject.ui.pages.simple.dialog.DialogPage
import com.example.mycomposeproject.ui.pages.simple.icon.IconPage
import com.example.mycomposeproject.ui.pages.simple.image.ImagePage
import com.example.mycomposeproject.ui.pages.simple.selector.SelectorPage
import com.example.mycomposeproject.ui.pages.simple.text.TextPage
import com.example.mycomposeproject.ui.pages.simple.textfield.TextFieldPage

@Composable
fun HomeNav() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "home_page"
        ) {
            composable("home_page") {
                HomePage(navController)
            }
            composable("text_page") {
                TextPage()
            }
            composable("text_field_page") {
                TextFieldPage()
            }
            composable("icon_page") {
                IconPage()
            }
            composable("image_page") {
                ImagePage()
            }
            composable("button_page") {
                ButtonPage()
            }
            composable("selector_page") {
                SelectorPage()
            }
            composable("dialog_page") {
                DialogPage()
            }
            composable("column_row_page") {
                ColumnRowPage()
            }
            composable("surface_page") {
                SurfacePage()
            }
            composable("constraint_layout_page") {
                ConstraintLayoutPage()
            }
            composable("composition_local_page") {
                CompositionLocalPage()
            }
            composable("state_page") {
                CounterScreen()
            }
            composable("recompose_page") {
                RecomposePage()
            }
            composable("lifecycle_page") {
                LifecyclePage()
            }
            composable("animation_page") {
                AnimationPage(
                    { navController.navigate("animated_visibility_page") },
                    { navController.navigate("animated_content_page") }
                )
            }
            composable("animated_visibility_page") {
                AnimatedVisibilityPage()
            }
            composable("animated_content_page") {
                AnimatedContentPage()
            }
        }
    }
}

@Composable
fun HomePage(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            navController.navigate("text_page")
        }) {
            Text(text = "Text组件")
        }
        Button(onClick = {
            navController.navigate("text_field_page")
        }) {
            Text(text = "TextField组件")
        }
        Button(onClick = {
            navController.navigate("icon_page")
        }) {
            Text(text = "Icon组件")
        }
        Button(onClick = {
            navController.navigate("image_page")
        }) {
            Text(text = "Image组件")
        }
        Button(onClick = {
            navController.navigate("button_page")
        }) {
            Text(text = "Button组件")
        }
        Button(onClick = {
            navController.navigate("selector_page")
        }) {
            Text(text = "选择器组件")
        }
        Button(onClick = {
            navController.navigate("dialog_page")
        }) {
            Text(text = "弹窗组件")
        }
        Button(onClick = {
            navController.navigate("column_row_page")
        }) {
            Text(text = "Column&Row")
        }
        Button(onClick = {
            navController.navigate("surface_page")
        }) {
            Text(text = "Surface")
        }
        Button(onClick = {
            navController.navigate("constraint_layout_page")
        }) {
            Text(text = "ConstraintLayout")
        }
        Button(onClick = {
            navController.navigate("composition_local_page")
        }) {
            Text(text = "CompositionLocal")
        }
        Button(onClick = {
            navController.navigate("state_page")
        }) {
            Text(text = "状态管理")
        }
        Button(onClick = {
            navController.navigate("recompose_page")
        }) {
            Text(text = "重组")
        }
        Button(onClick = {
            navController.navigate("lifecycle_page")
        }) {
            Text(text = "生命周期")
        }
        Button(onClick = {
            navController.navigate("animation_page")
        }) {
            Text(text = "动画")
        }
    }
}