package com.example.wellbeing.screens

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape


import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wellbeing.Exercise.ExerciseData
import com.example.wellbeing.ExerciseDataDetails
import com.example.wellbeing.composable.FruitGrid
import com.example.wellbeing.composable.FruitsDataDetails
import com.example.wellbeing.model.FruitsData
import com.example.wellbeing.ui.theme.*

//import com.example.wellbeing.Services.TrackingService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DailyScreen(){

    DailyExerciseUI()
    DailyLayout()




}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyExerciseUI()
{


        Column(modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(0.dp,0.dp,20.dp,20.dp))
            .background(Color.Black.copy(alpha = 0.3f))
            .size(50.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,


            ) {
            Text(
                text ="EXERCISE",
                color = Color.White,
                fontSize =  20.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = Poppins,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(horizontal = 10.dp)

            )
        }
    }



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DailyLayout()
{
    val navHostController = rememberNavController()



//    NavHost(
//        navController = navHostController,
//        startDestination = "fruits_data"
//    ){
//        composable("fruits_data"){
    FruitGrid(navController = navHostController)
//        }
//
//    }
}

