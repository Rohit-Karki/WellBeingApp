//package com.example.wellbeing
//
//
//import android.util.Log
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavType
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.navArgument
//import com.example.fitness_app.composable.DataForm
//import com.example.wellbeing.composable.FruitsDataDetails
//import com.example.wellbeing.custom.NavigationBar
//import com.example.wellbeing.model.FruitsData
//import com.google.gson.Gson
//
//@Composable
//fun Navigation()
//{
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "navigation_bar") {
//        composable("login_form"){
//            DataForm(navController = navController)
//        }
//        composable("navigation_bar") {
//            NavigationBar()
//        }
//        composable("grid_detail/{data}",
//            arguments = listOf(
//                navArgument("data"){
//                    type = NavType.StringType
//                }
//            )
//        ){navBackStackEntry ->
//            navBackStackEntry?.arguments?.getString("data")?.let { json->
//                Log.d("json","$json")
//                val data = Gson().fromJson(json, FruitsData::class.java)
//                FruitsDataDetails(data = data)
//            }
//        }
//
//    }
//
//}
//
//
//
