package com.example.wellbeing.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wellbeing.R

@Preview
@Composable
fun FoodScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Card(
                elevation = 4.dp,
                shape = RoundedCornerShape(10.dp)
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(2.dp)
                    .background(color = Color.Cyan)) {
                    horizontalProgressBar()
                }
            }

        }

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                elevation = 3.dp,
                shape = RoundedCornerShape(10.dp)
            ) {
                Box(modifier = Modifier.height(100.dp)
                ){
                    Image(painter = painterResource(id = R.drawable.breakfast),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentScale = ContentScale.Crop
                    )

                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .height(100.dp),
                        contentAlignment = Alignment.BottomStart

                    ){
                        Text(text = "Breakfast",
                            color = Color.White,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Left,
                            fontWeight = FontWeight.Light,
                            fontSize =22.sp
                        )
                    }
                }


                Column(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(2.dp)
//                    .background(color = Color.White)
                ){
//                    Text(text = "Breakfast",
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(10.dp),
//                        color = Color.Black,
//                        fontFamily = FontFamily.SansSerif,
//                        textAlign = TextAlign.Left,
//                        fontWeight = FontWeight.Light,
//                        fontSize =22.sp

//                        )

                    Button(onClick = { /*TODO*/ },

                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                        shape = CircleShape,
                        elevation =  ButtonDefaults.elevation(
                            defaultElevation = 10.dp,
                            pressedElevation = 15.dp,
                            disabledElevation = 0.dp,
                        ),
                        modifier = Modifier
                            .align(Alignment.End)




                    ) {
                        Text(text = "Add",
                            color = Color.White,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Light,
                            fontSize =10.sp,

                            )


                    }

                }


            }

        }

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                elevation = 3.dp,
                shape = RoundedCornerShape(10.dp)
            ) {

                Box(
                    modifier = Modifier.height(100.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lunch) ,
                        contentDescription = null ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp) ,
                        contentScale = ContentScale.Crop
                    )

                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .height(100.dp),
                        contentAlignment = Alignment.BottomStart

                    ){
                        Text(text = "Lunch",
                            color = Color.White,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Left,
                            fontWeight = FontWeight.Light,
                            fontSize =22.sp
                            )
                    }
                }




                Column(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(2.dp)
//                    .background(color = Color.White)
                ){
//                    Text(text = "Lunch",
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(10.dp),
//                        color = Color.Black,
//                        fontFamily = FontFamily.SansSerif,
//                        textAlign = TextAlign.Left,
//                        fontWeight = FontWeight.Light,
//                        fontSize =22.sp
//
//                    )

                    Button(onClick = { /*TODO*/ },

                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                        shape = CircleShape,
                        elevation =  ButtonDefaults.elevation(
                            defaultElevation = 10.dp,
                            pressedElevation = 15.dp,
                            disabledElevation = 0.dp,
                        ),
                        modifier = Modifier
                            .align(Alignment.End)
                    ) {
                        Text(text = "Add",
                            color = Color.White,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Light,
                            fontSize =10.sp,

                            )


                    }

                }


            }

        }

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                elevation = 3.dp,
                shape = RoundedCornerShape(10.dp)
            ) {

                Box(modifier = Modifier.height(100.dp)
                ){
                    Image(painter = painterResource(id = R.drawable.dinner),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentScale = ContentScale.Crop
                    )

                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .height(100.dp),
                        contentAlignment = Alignment.BottomStart

                    ){
                        Text(text = "Dinner",
                            color = Color.White,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Left,
                            fontWeight = FontWeight.Light,
                            fontSize =22.sp
                        )
                    }
                }

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(2.dp)
//                    .background(color = Color.White)
                ){
//                    Text(text = "Dinner",
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(10.dp),
//                        color = Color.Black,
//                        fontFamily = FontFamily.SansSerif,
//                        textAlign = TextAlign.Left,
//                        fontWeight = FontWeight.Light,
//                        fontSize =22.sp,

//                    )

                    Button(onClick = { /*TODO*/ },

                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                        shape = CircleShape,
                        elevation =  ButtonDefaults.elevation(
                            defaultElevation = 10.dp,
                            pressedElevation = 15.dp,
                            disabledElevation = 0.dp,
                        ),
                        modifier = Modifier
                            .align(Alignment.End)




                    ) {
                        Text(text = "Add",
                            color = Color.White,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Light,
                            fontSize =10.sp,

                            )


                    }

                }


            }

        }

    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            elevation = 3.dp,
            shape = RoundedCornerShape(10.dp)
        ) {


        }

    }



}
@Composable
fun horizontalProgressBar(){
        Column(modifier = Modifier.padding(20.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "0 kcal", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                Column(verticalArrangement = Arrangement.Center) {
                    Text(text = "Your Goal")
                    Text(text = "2957 kcal", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }
            LinearProgressIndicator(progress = 0.2f, modifier = Modifier
                .fillMaxWidth()
                .height(25.dp)
                .clip(RoundedCornerShape(15.dp)),
                backgroundColor = Color.LightGray,
                color = Color.Magenta) //progress color)
//            CircularProgressIndicator()
        }
}