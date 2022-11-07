package com.example.wellbeing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wellbeing.Exercise.ExerciseData
import com.example.wellbeing.ui.theme.PrimaryColor
import com.google.gson.Gson
import androidx.compose.foundation.layout.Column as Column1

@Composable
//fun ExerciseDataDetails(data: ExerciseData,
//    )
fun ExerciseDataDetails(data: ExerciseData,
){

        Column1(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column1(
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp)
                    .background(PrimaryColor),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Exercise",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

            }
            //        Spacer(modifier = Modifier.padding(1.dp))


            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = data.name,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.padding(1.dp))

            Text(
                text = data.desc,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(6.dp),
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,


                )
        }


    }
