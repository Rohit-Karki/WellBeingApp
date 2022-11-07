package com.example.wellbeing


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fitness_app.composable.DataForm
import com.example.wellbeing.custom.NavigationBar

@Composable
fun Navigation()
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "navigation_bar") {
        composable("login_form"){
            DataForm(navController = navController)
        }
        composable("navigation_bar") {
            NavigationBar()
        }
    }

}



