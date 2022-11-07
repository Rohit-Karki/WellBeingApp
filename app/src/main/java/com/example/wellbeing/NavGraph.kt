package com.example.wellbeing

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wellbeing.custom.CustomBottomNavigation
import com.example.wellbeing.custom.Screen
import com.example.wellbeing.screens.*

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Step.id
    ){
        composable(route = Screen.Step.id){
            StepScreen()
        }
        composable(route = Screen.Water.id){
            WaterScreen()
        }
        composable(route = Screen.Daily.id){
            DailyScreen()
        }
        composable(route = Screen.Food.id){
            FoodScreen()
        }
        composable(route = Screen.Settings.id){
            SettingScreen()
        }

    }
}