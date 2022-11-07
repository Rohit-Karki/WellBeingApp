@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package com.example.wellbeing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wellbeing.Exercise.ExerciseData
import com.example.wellbeing.ui.theme.*
import com.google.gson.Gson


@Composable
//fun ExerciseDataDetails(data: ExerciseData,
//    )
fun ExerciseDataDetails(data: ExerciseData
){

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
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

@Composable
@Preview
fun ExerciseGridUI()
{
    
    Card{
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),


        ) {
            Text(
                text = "Push Ups",
                fontFamily = Poppins,
                color = PrimaryColor,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,


            )
        }
        Spacer(modifier = Modifier.width(14.dp))
        Card(

            modifier = Modifier
                .padding(vertical = 50.dp)

                .fillMaxWidth()

                .height(400.dp),
            backgroundColor = BackGroundColor.copy(alpha = 0.5f),
            elevation = 1.dp,
            shape = RoundedCornerShape(50.dp,50.dp,0.dp,0.dp)
        ) {
            Row {
                Column(
                    modifier = Modifier

                        .padding(20.dp),
                ) {
                    Image(painter = painterResource(id = R.drawable.pushups),
                        contentDescription = null,

                        modifier = Modifier
                            .shadow(elevation = 1.dp, shape = RectangleShape)
                            .clip(shape = Shapes.medium)
                            .height(100.dp),
                        contentScale = ContentScale.Crop
                    )

                }
                Column(
                    modifier = Modifier

                        .padding(20.dp),
                ) {
                    Text(
                        text = "Description",

                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                    )
                    Spacer(modifier = Modifier.width(0.dp))
                    Text(
                        text = "One of the most basic yet effective bodyweight moves you can perform because of the number of muscles that are recruited to perform them.",

                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                    )

                }
            }
            Row() {
                Column(modifier = Modifier.padding(vertical = 160.dp)) {
                    Card(
                        shape = RoundedCornerShape(0,100,100,0),
                        backgroundColor = Color.White,
                        modifier = Modifier
                            .height(180.dp)
                            .width(180.dp)

                    ) {
                        Row {
                            Column {
                                Row {
                                    Text(
                                        text = "320",
                                        fontFamily = Poppins,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 40.sp,
                                        color = Color.Green,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.padding(10.dp)
                                    )
                                    Text(
                                        text = "cals",
                                        fontFamily = Poppins,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.padding(vertical = 28.dp)
                                    )
                                }

                            }

                        }

                    }
                }

                Column(modifier = Modifier.padding(vertical = 175.dp, horizontal = 20.dp)) {
                    Row {
                        val textState = remember{ mutableStateOf("") }
                        TextField(
                            modifier = Modifier
                                .padding(horizontal = 20.dp)
                                .width(110.dp)
                                .height(40.dp)
                            ,
                            value = textState.value,
                            onValueChange = {
                                textState.value = it
                            },
                            label = {
                                Text(text = "Enter Amount", fontSize = 10.sp)
                            }
                        )
                        Text(
                            text = "min",
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Light,
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(vertical = 15.dp))
                    }

                }


                }
            Spacer(modifier = Modifier.width(190.dp))


            }



    }
    Box(modifier = Modifier
        .padding(vertical = 320.dp, horizontal = 10.dp)
        .fillMaxWidth()
    )
    {
        val textState = remember{ mutableStateOf("") }
        TextField(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .height(40.dp)
            ,
            value = textState.value,
            onValueChange = {
                textState.value = it
            },
            label = {
                Text(text = "Note", fontSize = 10.sp)
            }
        )
    }
    Box(modifier = Modifier
        .padding(vertical = 380.dp, horizontal = 10.dp)
        .fillMaxWidth()
    )
    {
        val textState = remember{ mutableStateOf("") }
        Button(onClick ={},
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .height(40.dp)
            ,

        )
        {
            Text(text = "SAVE", fontSize = 10.sp)
        }
    }

}






