<<<<<<< HEAD:app/src/main/java/com/example/wellbeing/Exercise/ExerciseDataDetails.kt
package com.example.wellbeing.Exercise
=======
package com.rohit.wellbeing.Exercise
>>>>>>> 1134a61015c2df604f792be88aa027f6f5acadd5:app/src/main/java/com/rohit/wellbeing/Exercise/ExerciseDataDetails.kt

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
<<<<<<< HEAD:app/src/main/java/com/example/wellbeing/Exercise/ExerciseDataDetails.kt

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rohit.wellbeing.R
import com.rohit.wellbeing.model.ExerciseData
import com.rohit.wellbeing.ui.theme.*
=======
import com.rohit.wellbeing.model.ExerciseData
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rohit.wellbeing.R
import com.rohit.wellbeing.ui.theme.*
>>>>>>> 1134a61015c2df604f792be88aa027f6f5acadd5:app/src/main/java/com/rohit/wellbeing/Exercise/ExerciseDataDetails.kt

@Composable
fun ExerciseGridUI(data: ExerciseData)
{
    Column( modifier = Modifier
        .verticalScroll(rememberScrollState())) {
        HeadingCard()
        ExerciseBody(data)
    }
}

@Composable
fun HeadingCard() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
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
fun ExerciseBody(data: ExerciseData) {
    Card(
        modifier = Modifier
            .padding(vertical = 0.dp)
            .fillMaxSize(),
        elevation = 1.dp,
        backgroundColor = Color.Gray,
        shape = RoundedCornerShape(50.dp, 50.dp, 0.dp, 0.dp)
    ) {
        HeadingText(data)
        ExercisePhoto(data)
        ExerciseOthers(data)
    }
}


@Composable
fun HeadingText(data: ExerciseData) {
    Text(
        text = data.name,
        fontFamily = Poppins,
        color = Color.White,
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
    modifier = Modifier.padding(vertical = 10.dp)
    )
}

@Composable
fun ExercisePhoto(data: ExerciseData) {
    Box(modifier = Modifier
        .padding(vertical = 80.dp),
    ) {
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
                    .shadow(elevation = 1.dp, shape = RectangleShape)
                    .fillMaxWidth()
                    .height(300.dp)
                    ,
                contentScale = ContentScale.Crop
            )
//            Spacer(modifier = Modifier.padding(10.dp))
    }
}

@Composable
fun ExerciseOthers(data: ExerciseData) {
        Column(
            modifier = Modifier.padding(top = 420.dp, bottom = 80.dp)
        ) {
            Text(
                text = data.desc,
                modifier = Modifier
//                    .align(Alignment.BottomCenter)
                    .padding(bottom = 10.dp),
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
            )
            Row() {
                Card(
                    shape = RoundedCornerShape(0, 100, 100, 0),
                    backgroundColor = Color.White,
                    modifier = Modifier
                        .height(120.dp)
                        .width(180.dp),
                    elevation = 0.dp
                ) {
                    Row() {
                        Text(
                            text = data.calorie.toString(),
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
                Row(modifier = Modifier.padding(top = 40.dp)) {
                    val textState = remember { mutableStateOf("") }
                    TextField(
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .width(110.dp)
                            .height(30.dp),
                        value = textState.value,
                        onValueChange = {
                            textState.value = it
                        },
                        label = {
                            Text(
                                text = "Enter Amount(30)",
                                fontSize = 8.sp,
                                modifier = Modifier.padding(5.dp)
                            )
                        }
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        colors = buttonColors(Color.Green),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 3.dp,
                            pressedElevation = 5.dp,
                            disabledElevation = 0.dp
                        ),
                        modifier = Modifier
                            .width(70.dp)
                            .height(30.dp)
                    ) {
                        Text(
                            text = "min",
                            fontWeight = FontWeight.Light,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.width(100.dp))
}




