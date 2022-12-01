package com.example.wellbeing.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wellbeing.ViewModel.MainViewModel
import com.example.wellbeing.ui.theme.Poppins
import com.example.wellbeing.ui.theme.PrimaryColor
import com.example.wellbeing.ui.theme.Shapes
import androidx.compose.material.Button as Button1
import androidx.compose.material.Text as Text1

@Composable
fun StepScreen(viewModel: MainViewModel) {
//    fun sendCommandToService(action: String, mContext: Context) {
//        mContext.startService(Intent(mContext, TrackingService::class.java).also {
//            it.action = Constants.ACTION_START_OR_RESUME_SERVICE
//        })
//    }
    StepCounterCard(viewModel)
}


@SuppressLint("SuspiciousIndentation")
@Composable
fun StepCounterCard(viewModel: MainViewModel) {
    val steps = viewModel.stepCount.collectAsState()
    val isRunning = viewModel.isRunning.collectAsState()

    Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .size(300.dp)
        ) {
            Column(verticalArrangement = Arrangement.SpaceEvenly) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text1(
                            text = steps.value.toString(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 50.sp
                        )
                        Button1(
                            modifier = Modifier
                                .padding(0.dp)
                                .clip(Shapes.medium),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                            elevation = ButtonDefaults.elevation(
                                defaultElevation = 3.dp,
                                pressedElevation = 5.dp,
                                disabledElevation = 0.dp
                            ), onClick = { /* Do something! */ }) {
                            if(isRunning.value) {
                                Text1("Resumed")
                            }else{
                                Text1(text = "Paused")
                            }
                        }
                    }
                    Spacer(Modifier.width(180.0.dp))
                    OutlinedButton(
                        modifier = Modifier
                            .padding(0.dp)
                            .clip(Shapes.medium),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 3.dp,
                            pressedElevation = 5.dp,
                            disabledElevation = 0.dp
                        ),
                        onClick = {
                            if(isRunning.value){
                                viewModel.stopListening()
                            }
                            else{
                                viewModel.startListening()
                            }
//                        sendCommandToService(
//                            Constants.ACTION_START_OR_RESUME_SERVICE,
//                            mContext)
                        },
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),

                        ) {
                        Icon(
                            Icons.Default.PlayArrow,
                            contentDescription = "Play",
                            tint = PrimaryColor
                        )
                    }
                }
                Spacer(
                    Modifier
                        .size(30.dp)
                        .fillMaxWidth(1f)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.padding(10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .height(100.dp)
                            .width(90.dp)
                    ) {
                        Icon(
                            Icons.Default.LocationOn,
                            contentDescription = "Location",
                            tint = PrimaryColor,
                            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                        )
                        Text1(
                            text = "1.5",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = Poppins,
                            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                        )
                        Text1(
                            text = "Km",
                            fontSize = 9.sp,

                            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                        )
                    }
                    Spacer(Modifier.size(20.dp))
                    Column(
                        modifier = Modifier
                            .height(100.dp)
                            .width(90.dp)
                    ) {
                        Icon(
                            Icons.Default.ArrowForward,
                            contentDescription = "Location",

                            tint = PrimaryColor,
                            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                        )
                        Text1(
                            text = "150",
                            fontSize = 18.sp,
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                        )
                        Text1(
                            text = "Calories",
                            fontSize = 9.sp,

                            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                        )
                    }
                    Spacer(Modifier.size(10.dp))
                    Column(
                        modifier = Modifier
                            .height(100.dp)
                            .width(90.dp)
                    ) {
                        Icon(
                            Icons.Default.AccountBox,
                            contentDescription = "Location",
                            tint = PrimaryColor,
                            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                        )
                        Text1(
                            text = "0h 19m",
                            fontFamily = Poppins,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                        )
                        Text1(
                            text = "Walking Time",
                            fontSize = 9.sp,
                            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                        )
                    }
                }
            }
        }
}
