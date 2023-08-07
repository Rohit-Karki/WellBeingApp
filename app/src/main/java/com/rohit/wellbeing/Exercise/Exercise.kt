package com.rohit.wellbeing.screens

import android.content.Context
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.wellbeing.R
import com.rohit.wellbeing.Exercise.ExerciseDetailsScreen
import com.rohit.wellbeing.model.ExerciseData
import com.rohit.wellbeing.ui.theme.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Composable
fun Exercise(){
    val context = LocalContext.current
    val dataFileString = getJsonDataFromAsset(context,"ExerciseList.json")
    val gson = Gson()
    val gridSampleType = object :TypeToken<List<ExerciseData>>(){}.type
    val Exercisedata : List<ExerciseData> = gson.fromJson(dataFileString,gridSampleType)

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(BackGroundColor)
            .padding(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text ="Exercise",
                color = Color.White,
                fontSize =  20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        LazyColumn(

            modifier = Modifier.padding(10.dp)
        ){
            items(Exercisedata){ data->
                ExerciseDataGridItem(data, rememberNavController())
            }
        }

    }





}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseDataGridItem(data: ExerciseData, navController: NavController) {

    val navigator = LocalNavigator.currentOrThrow

    Card(
        modifier = Modifier
        .clickable
        {
            navigator.push(ExerciseDetailsScreen(data))
        }
        .padding(10.dp)
        .fillMaxSize(),
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(modifier = Modifier) {
            Image(painter = painterResource(
                id =  when(data.id){
                    1L-> R.drawable.lunges
                    2L -> R.drawable.pushups
                    3L -> R.drawable.squats
                    4L -> R.drawable.burpees
                    5L -> R.drawable.sideplank
                    6L -> R.drawable.plank
                    7L -> R.drawable.glute
                    8L -> R.drawable.abnominal
                    9L -> R.drawable.bent
                    10L -> R.drawable.bridge
                    11L -> R.drawable.straight
                    12L -> R.drawable.bicycle
                    13L -> R.drawable.stretch
                    14L -> R.drawable.jumping
                    15L -> R.drawable.mountain
                    16L -> R.drawable.bear
                    17L -> R.drawable.flutter
                    else -> R.drawable.flutter
                }
            ),
                contentDescription = "Grid Image",
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)
                    .clip(RoundedCornerShape(5.dp)),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.padding(3.dp))
            Text(
                text = data.name,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                fontSize =  15.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.padding(1.dp))
            Text(
                text = data.desc,
                modifier = Modifier
                    .padding(7.dp,0.dp,0.dp,20.dp)
                ,
                fontSize =  13.sp,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

fun getJsonDataFromAsset(context: Context, data: String):String {
    return context.assets.open(data).bufferedReader().use { it.readText() }
}
