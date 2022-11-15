package com.example.wellbeing.food

import android.app.usage.NetworkStats
import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.wellbeing.R
import androidx.compose.ui.text.TextStyle
import com.example.wellbeing.ViewModel.FoodViewModel
import com.example.wellbeing.model.FoodCalorie
import com.example.wellbeing.model.NetworkState

@Composable
fun FoodScreen(foodViewModel: FoodViewModel) {
    val navigator = LocalNavigator.currentOrThrow
    val foodCalorie = foodViewModel.foodCalorie.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 60.dp)
            .verticalScroll(state = rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            when(foodCalorie.value){
                is NetworkState.Loading -> {
                    AnimatedShimmer()
                }
                is NetworkState.Success -> {
                    ProgressBarCard((foodCalorie.value as NetworkState.Success<FoodCalorie>).data)
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        // Breakfast
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
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
                    Button(onClick = {
                                     navigator.push(BreakFastDetailScreen)
                    },
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
        //Lunch

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
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
                ){
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
        //Dinner
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
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
                ){
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
}

@Composable
fun ProgressBarCard(foodCalorie: FoodCalorie){
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(15.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(2.dp)
                .background(color = Color.White)) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = foodCalorie.date)
            }
            CircularProgressbar1(foodCalorie)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.width(80.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Proteins, gr")
                    LinearProgressIndicator(
                        progress = foodCalorie.proteins.toFloat(),
                        modifier = Modifier
                            .height(25.dp)
                            .clip(RoundedCornerShape(15.dp)),
                        backgroundColor = Color(175,238,238),
                        color = Color(127,255,212)
                    ) //progress color)
                    Text(text = "${foodCalorie.proteins} of 97")
                }

                Column(
                    modifier = Modifier.width(80.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Fats, gr")
                    LinearProgressIndicator(
                        progress = foodCalorie.fats.toFloat(),
                        modifier = Modifier
                            .height(25.dp)
                            .clip(RoundedCornerShape(15.dp)),
                        backgroundColor = Color(147,112,219),
                        color = Color(123,104,238)
                    ) //progress color)
                    Text(text = "${foodCalorie.fats} of 97")
                }

                Column(
                    modifier = Modifier.width(80.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Carbs, gr")
                    LinearProgressIndicator(
                        progress = foodCalorie.carbs.toFloat(),
                        modifier = Modifier
                            .height(25.dp)
                            .clip(RoundedCornerShape(15.dp)),
                        backgroundColor = Color(65,105,225),
                        color = Color(0,0,128)
                    ) //progress color)
                    Text(text = "${foodCalorie.carbs} of 97")
                }
            }
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
        }
}

@Composable
fun CircularProgressbar1(
    foodCalorie: FoodCalorie,
    size: Dp = 260.dp,
    foregroundIndicatorColor: Color = Color(255,20,147),
    shadowColor: Color = Color.LightGray,
    indicatorThickness: Dp = 24.dp,
    dataUsage: Float = foodCalorie.totalCalories.toFloat(),
    animationDuration: Int = 1000,
    dataTextStyle: TextStyle = TextStyle(
        fontWeight=FontWeight.ExtraBold,
        fontSize = MaterialTheme.typography.h3.fontSize
    ),
    remainingTextStyle: TextStyle = TextStyle(
        fontSize = 16.sp
    )
) {
    // It remembers the data usage value
    var dataUsageRemember by remember {
        mutableStateOf(-1f)
    }

    // This is to animate the foreground indicator
    val dataUsageAnimate = animateFloatAsState(
        targetValue = dataUsageRemember,
        animationSpec = tween(
            durationMillis = animationDuration
        )
    )

    // This is to start the animation when the activity is opened
    LaunchedEffect(Unit) {
        dataUsageRemember = dataUsage
    }

    Box(
        modifier = Modifier
            .size(size),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(size)
        ) {
            // For shadow
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(shadowColor, Color(255,192,203)),
                    center = Offset(x = this.size.width / 2, y = this.size.height / 2),
                    radius = this.size.height / 2
                ),
                radius = this.size.height / 2,
                center = Offset(x = this.size.width / 2, y = this.size.height / 2)
            )

            // This is the white circle that appears on the top of the shadow circle
            drawCircle(
                color = Color.White,
                radius = (size / 2 - indicatorThickness).toPx(),
                center = Offset(x = this.size.width / 2, y = this.size.height / 2)
            )

            // Convert the dataUsage to angle
            val sweepAngle = (dataUsageAnimate.value) * 360 / 100

            // Foreground indicator
            drawArc(
                color = foregroundIndicatorColor,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = indicatorThickness.toPx(), cap = StrokeCap.Round),
                size = Size(
                    width = (size - indicatorThickness).toPx(),
                    height = (size - indicatorThickness).toPx()
                ),
                topLeft = Offset(
                    x = (indicatorThickness / 2).toPx(),
                    y = (indicatorThickness / 2).toPx()
                )
            )
        }

        // Display the data usage value
        DisplayText(
            animateNumber = dataUsageAnimate,
            dataTextStyle = dataTextStyle,
            remainingTextStyle = remainingTextStyle
        )
    }
    Spacer(modifier = Modifier.height(32.dp))
}

@Composable
private fun DisplayText(
    animateNumber: State<Float>,
    dataTextStyle: TextStyle,
    remainingTextStyle: TextStyle
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Text that shows the number inside the circle
        Text(
            text = (animateNumber.value).toInt().toString() ,
            style = dataTextStyle
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "of 1200 kcal",
            style = remainingTextStyle
        )
    }
}