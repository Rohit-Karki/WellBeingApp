package com.example.wellbeing.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wellbeing.BottomNavGraph


val currentScreen= mutableStateOf<Screen>(Screen.Step)

@Composable
fun NavigationBar(navController: NavHostController = rememberNavController())
{
    Surface(color = Color(0xF96167), modifier = Modifier
        .background(color = "#161B21".color)
        .fillMaxSize()
        ){
        Scaffold(

            bottomBar =
//            {
//                CustomBottomNavigation(currentScreenId = currentScreen.value.id, ) {
//                    currentScreen.value = it
//
//                }
            {
                CustomBottomNavigation(navController = navController)
            }
        ) {
            BottomNavGraph(navController = navController)
        }
    }

}
val String.color
    get() = Color(android.graphics.Color.parseColor(this))