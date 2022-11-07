package com.example.wellbeing.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wellbeing.R
import com.example.wellbeing.model.FruitsData
import com.example.wellbeing.ui.theme.Purple500


@Composable
fun FruitsDataDetails(data: FruitsData){
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier.fillMaxWidth()
            .height(50.dp)
            .background(Purple500),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text ="Fruits Calories and Sugar",
                color = Color.White,
                fontSize =  20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.padding(1.dp))
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
                .clip(RoundedCornerShape(10.dp)),
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = data.name,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            color = Color.Black,
            fontSize =  20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(1.dp))
        Text(
            text = data.desc,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(6.dp),
            color = Color.Black,
            fontSize =  16.sp,
            fontWeight = FontWeight.Normal,
            )
    }



}