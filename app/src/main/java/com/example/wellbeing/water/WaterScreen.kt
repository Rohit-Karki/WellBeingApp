package com.example.wellbeing.water

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.WaterDrop
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign


import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wellbeing.ViewModel.ReminderViewModel
//import com.example.wellbeing.ViewModel.ReminderViewModel
import com.example.wellbeing.ui.theme.*
import kotlinx.coroutines.InternalCoroutinesApi
import java.text.SimpleDateFormat

@OptIn(InternalCoroutinesApi::class)
@Composable
fun WaterScreen(viewModel: ReminderViewModel){
    Card()
    {
        WaterHeading()
        WaterUITheme(viewModel)
        WaterChart()
    }

}

@Composable
fun WaterHeading() {
    Card(modifier = Modifier
        .fillMaxWidth(),
        backgroundColor = WaterColor,
        elevation = 1.dp,
        shape = RoundedCornerShape(0.dp,0.dp,10.dp,10.dp)
    )
    {
        Text(
            text = "WATER REMINDER",
            fontFamily = Poppins,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )
    }

}

@OptIn(InternalCoroutinesApi::class)
@Composable
fun WaterUITheme(viewModel: ReminderViewModel){
    val waterconsumed = viewModel.waterIntakeQuantity.collectAsState()
    val progress = viewModel.progress.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Spacer(Modifier.height(100.dp))
        Box( contentAlignment = Alignment.Center ){
            Icon(
                imageVector = Icons.Outlined.WaterDrop,
                contentDescription = null,
                tint = WaterColor.copy(alpha = 0.73f),
                modifier = Modifier
                    .size(150.dp)
                    ,
            )
            if(waterconsumed.value.value < 3600){
                Text(
                    text = "${waterconsumed.value.value}",
                    fontFamily = Poppins,
                    modifier = Modifier.padding(10.dp),
                    fontSize = 20.sp,
                    )
            }
            else{
                Text(
                    text = "COMPLETED",
                    fontFamily = Poppins,
                    modifier = Modifier.padding(10.dp),
                    fontSize = 20.sp,
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold
                    )
            }
            CircularProgressIndicator(
                progress = progress.value,
                modifier = Modifier
                    .size(200.dp)
                ,
                color = PrimaryColor,
                strokeWidth = 23.dp,
                )
        }

        Button(
            modifier= Modifier
                .clip(Shapes.medium)
                .height(46.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor),
                elevation =  ButtonDefaults.elevation(
                defaultElevation = 3.dp,
                pressedElevation = 5.dp,
                disabledElevation = 0.dp),
                onClick = {
                    viewModel.increaseWaterIntake()
                }
            ) {
            Text(
                text = "400 ml",
                fontFamily = Poppins,
                color = Color.White,
                modifier = Modifier.padding(5.dp),
                fontSize = 13.sp
            )
        }
    }
}


@Composable
fun WaterChart(){

    val max_value = 1000
    val context = LocalContext.current

    // BarGraph Dimensions
    val barGraphHeight by remember { mutableStateOf(200.dp) }
    val barGraphWidth by remember { mutableStateOf(20.dp) }
    // Scale Dimensions
    val scaleYAxisWidth by remember { mutableStateOf(30.dp) }
    val scaleLineWidth by remember { mutableStateOf(2.dp) }

    val sdf = SimpleDateFormat("'Date\n'dd-MM-yyyy '\n\nand\n\nTime\n'HH:mm:ss z")
    val currentDateAndTime = sdf.format(java.util.Date())
    Column(
        modifier = Modifier
            .padding(top = 380.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(barGraphHeight),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start
        ) {
            // scale Y-Axis
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(scaleYAxisWidth),
                contentAlignment = Alignment.BottomCenter
            ) {


            }

            // Y-Axis Line
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(scaleLineWidth)
                    .background(Color.Black)
            )

            // graph
                Box(
                    modifier = Modifier
                        .padding(start = barGraphWidth, bottom = 5.dp)
                        .clip(CircleShape)
                        .width(barGraphWidth)
                        .fillMaxHeight()
                        .background(Purple500)
                        .clickable {

                        }
                )
        }

        // X-Axis Line
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(scaleLineWidth)
                .background(Color.Black)
        )

        // Scale X-Axis
        Row(
            modifier = Modifier
                .padding(start = scaleYAxisWidth + barGraphWidth + scaleLineWidth)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(barGraphWidth)
        ) {
            Text(text = "12")
            Text(text = "1")
            Text(text = "2")
            Text(text = "3")
            Text(text = "4")
            Text(text = "5")
            Text(text = "6")
            Text(text = "7")
            Text(text = "8")
            Text(text = "9")
            Text(text = "10")
            Text(text = "11")
            }
        }
}


