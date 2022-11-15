@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package com.example.wellbeing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wellbeing.ui.theme.*


@Composable
@Preview
fun ExerciseGridUI()
{
        HeadingCard()
        ExerciseBody()
}

@Composable
fun HeadingCard() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            ) {
            Text(
                text = "EXERCISES",
                fontFamily = Poppins,
                color = PrimaryColor,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
            )
        }
}


@Composable
fun ExerciseBody() {
        Card(
            modifier = Modifier
                .padding(vertical = 70.dp)
                .fillMaxSize(),
            elevation = 1.dp,
            backgroundColor = Color.Gray,
            shape = RoundedCornerShape(50.dp,50.dp,0.dp,0.dp)
        ){
            HeadingText()
            ExercisePhoto()
            ExerciseOthers()
        }
}

@Composable
fun HeadingText() {
    Text(
        text = "Push Ups",
        fontFamily = Poppins,
        color = Color.White,
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
    modifier = Modifier.padding(vertical = 30.dp)
    )
}

@Composable
fun ExercisePhoto() {
    Box(modifier = Modifier
        .padding(vertical = 85.dp),
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            Image(painter = painterResource(id = R.drawable.pushups),
                contentDescription = null,

                modifier = Modifier
                    .shadow(elevation = 1.dp, shape = RectangleShape)
                    .clip(shape = Shapes.medium)
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )

        }
        Spacer(modifier = Modifier.width(20.dp))
        Column(
            modifier = Modifier

                .fillMaxWidth()
                .padding(top = 290.dp)
        ) {
            Text(
                text = "One of the most basic yet effective bodyweight moves you can perform because of the number of muscles that are recruited to perform them.",

                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(20.dp)
            )
        }
    }
}

@Composable
fun ExerciseOthers()
{

    Column(modifier = Modifier.padding(top = 460.dp)) {
        Row() {
            Card(
                shape = RoundedCornerShape(0, 100, 100, 0),
                backgroundColor = Color.White,
                modifier = Modifier
                    .height(120.dp)
                    .width(180.dp),
                elevation = 0.dp

            ) {
                Row {
                    Column {
                        Row(

                        ) {
                            Text(
                                text = "320",
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Bold,
                                fontSize = 40.sp,
                                color = Color.Green,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 30.dp, start = 20.dp)
                            )

                            Text(
                                text = "cals",
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Bold,
                                fontSize = 19.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 50.dp, start = 10.dp)
                            )

                        }

                    }


                }
            }

            Row(modifier = Modifier.padding(top = 40.dp)) {
                val textState = remember{ mutableStateOf("") }
                TextField(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .width(110.dp)
                        .height(30.dp)
                    ,

                    value = textState.value,
                    onValueChange = {
                        textState.value = it
                    },
                    label = {
                        Text(text = "Enter Amount(30)", fontSize = 8.sp)
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = { /*TODO*/ },
                    colors = buttonColors(Color.Green),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 3.dp,
                        pressedElevation = 5.dp,
                        disabledElevation = 0.dp),
                modifier = Modifier
                    .width(70.dp)
                    .height(30.dp)){
                    Text(
                        text = "min",
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                    )

                }

            }
            

        }
        Box(modifier = Modifier
            .padding(top = 30.dp)
            .fillMaxWidth()
            .height(50.dp)
        ){
            val textState = remember{ mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .height(60.dp)
                ,
                value = textState.value,
                onValueChange = {
                    textState.value = it
                },
                label = {
                    androidx.compose.material.Text(
                        text = "Note",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }
            )
        }

        Box(modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
            .height(30.dp)
        )
        {
            val textState = remember{ mutableStateOf("") }
            Button(onClick ={},
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .height(60.dp)

                ,
                colors = ButtonDefaults.buttonColors(backgroundColor = WaterColor),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 3.dp,
                    pressedElevation = 5.dp,
                    disabledElevation = 0.dp
                ),


                )
            {
                androidx.compose.material.Text(text = "SAVE", fontSize = 14.sp)
            }
        }

    }


}





