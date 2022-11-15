package com.example.wellbeing.screens

import androidx.compose.animation.core.animateFloatAsState
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


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.example.wellbeing.ViewModel.ReminderViewModel
import com.example.wellbeing.ui.theme.*
import kotlinx.coroutines.InternalCoroutinesApi
import java.text.SimpleDateFormat

@Preview
@OptIn(InternalCoroutinesApi::class)
@Composable
fun WaterScreen(){
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            //.background(color = "#161B21".color)
//        ,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Icon(
//            imageVector = Icons.Default.WaterDrop,
//            contentDescription = "profile",
//            tint = "#F4A950".color
//        )
//        // Text to Display the current Screen
//        Text(text = "Drinking Water", color = "#F96167".color)
//    }
//    val reminderViewModel: ReminderViewModel = viewModel()
//    val waterIntakeValue = reminderViewModel.waterIntakeQuantity.collectAsState()
//    Text(text = "Hello $waterIntakeValue!")
    Card()
    {
        WaterHeading()
        WaterUITheme()
        WaterNote()
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

@Preview
@Composable
fun WaterUITheme(){
    var waterconsumed by remember { mutableStateOf(0) }
    var progress by remember { mutableStateOf(0f) }
    val animatedProgress = animateFloatAsState(
        targetValue = progress,
    animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec ).value
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Spacer(Modifier.height(75.dp))
        Box( contentAlignment = Alignment.Center ){
            Icon(
                imageVector = Icons.Outlined.WaterDrop,
                contentDescription = null,
                tint = WaterColor.copy(alpha = 0.73f),
                modifier = Modifier
                    .size(150.dp)
                    ,
            )
            if(waterconsumed < 3600){
                Text(
                    text = "$waterconsumed",
                    fontFamily = Poppins,
                    modifier = Modifier.padding(10.dp),
                    fontSize = 20.sp,
                    )
            }
            else{
//                Icon(
//                    imageVector = Icons.Outlined.BorderRight,
//                    contentDescription = null,
//                    tint = Color.Blue.copy(alpha = 0.69f),
//                    modifier = Modifier
//                        .size(50.dp)
//                    ,
//
//                    )
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
                progress = animatedProgress ,
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
                                if(progress<1f){
                                    progress += 0.1f
                                    waterconsumed += 400
                                }
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
fun WaterNote()
{
    Spacer(Modifier.height(120.dp))
    Box(modifier = Modifier
        .padding(top = 350.dp, start = 10.dp)
        .fillMaxWidth()
    )
    {
        val textState = remember{ mutableStateOf("") }
        TextField(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .height(50.dp)
            ,
            value = textState.value,
            onValueChange = {
                textState.value = it
            },
            label = {
                Text(text = "Note", fontSize = 14.sp, textAlign = TextAlign.Center)
            }
        )
    }
    Box(modifier = Modifier
        .padding(top = 410.dp, start = 10.dp)
        .fillMaxWidth()
        .height(40.dp)
    )
    {
        val textState = remember{ mutableStateOf("") }
        Button(onClick ={},
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .height(50.dp)

            ,
            colors = ButtonDefaults.buttonColors(backgroundColor = WaterColor),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 3.dp,
                pressedElevation = 5.dp,
                disabledElevation = 0.dp
            ),


        )
        {
            Text(text = "SAVE", fontSize = 14.sp)
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
            .padding(top = 480.dp)
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

    Column(
        modifier = Modifier.padding(top = 720.dp, start = 20.dp)
    ) {
        Text(currentDateAndTime.toString())

    }
    }


