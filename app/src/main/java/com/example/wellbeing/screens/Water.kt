package com.example.wellbeing.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.WaterDrop
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.example.wellbeing.ViewModel.ReminderViewModel
import com.example.wellbeing.ui.theme.*
import kotlinx.coroutines.InternalCoroutinesApi

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
//
//    Text(text = "Hello $waterIntakeValue!")
    WaterHeading()
    WaterUITheme()
}

@Composable
fun WaterHeading() {
    Text(
        text = "Drinking Water",
        fontFamily = Poppins,
        color = PrimaryTextColor,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 10.dp),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 30.sp
    )
}


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
        Spacer(Modifier.height(150.dp))
        Box( contentAlignment = Alignment.Center ){
            Icon(
                imageVector = Icons.Outlined.WaterDrop,
                contentDescription = null,
                tint = Color.Blue.copy(alpha = 0.69f),
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
        Spacer(Modifier.height(30.dp))
        Button(
            modifier=Modifier
                .clip(Shapes.medium),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
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
                color = PrimaryTextColor,
                modifier = Modifier.padding(5.dp),
                fontSize = 20.sp
            )
        }
    }

}


