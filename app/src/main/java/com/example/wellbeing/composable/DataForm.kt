package com.example.fitness_app.composable


import android.app.TimePickerDialog
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.wellbeing.ViewModel.LoginViewModel
import com.example.wellbeing.ViewModel.MainViewModel
import java.util.*

@Preview
@Composable
fun DataForm(navController: NavController) {

    val loginViewModel = hiltViewModel<LoginViewModel>()

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .background(Cyan)
            .padding(10.dp)
    ) {

        val context = LocalContext.current

        Text(
                "Let's Get Started",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light,
                fontSize = 40.sp,
                )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center ,
            modifier = Modifier.fillMaxSize(),
        ) {
            var name by remember {
                mutableStateOf("")
            }

           TextField(
                value = name,
                onValueChange = { newText -> name = newText },
                label = {Text ("Name")},
                shape = CircleShape ,
                modifier = Modifier.padding(5.dp),
                singleLine = true,
                leadingIcon = { Icon(
                    imageVector = Icons.Sharp.Person,
                    contentDescription = "Person Icon"
                )
                }
            )

            var age by remember {
                mutableStateOf("")
            }

            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                placeholder = {},
                value = age,
                onValueChange = { newText -> age = newText },
                label = {Text ("Age")},
                shape = CircleShape,
                modifier = Modifier.padding(5.dp),
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Sharp.Face,
                        contentDescription = "Age"
                    )
                }
            )

            var weight by remember {
                mutableStateOf("")
            }

            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = weight,
                onValueChange = { newText -> weight = newText },
                label = {Text ("Weight")},
                shape = CircleShape,
                modifier = Modifier.padding(5.dp),
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Sharp.Accessibility,
                        contentDescription = "Weight"
                    )
                }
            )

            var height by remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = height,
                onValueChange = {newText -> height = newText},
                label = {Text ("Height")},
                shape = CircleShape,
                modifier = Modifier.padding(5.dp),
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Sharp.ArrowUpward,
                        contentDescription = "Height"
                    )
                }
            )




            val calendar1 = Calendar.getInstance()

            val context = LocalContext.current
            val wakeUpTimeInMillis = remember { mutableStateOf(0L)}
            val wakeUpTime = remember { mutableStateOf("")}

            val wakeUpPickerDialog = TimePickerDialog(
                context,
                {_,
                    hour: Int,
                    minute : Int ->
                    val wakeUpCalendar = Calendar.getInstance()
                    wakeUpCalendar.set(Calendar.HOUR_OF_DAY, hour)
                    wakeUpCalendar.set(Calendar.MINUTE, minute)
                    wakeUpTimeInMillis.value = wakeUpCalendar.timeInMillis
                    wakeUpTime.value = "$hour:$minute"
                }, calendar1.get(Calendar.HOUR_OF_DAY) , calendar1.get(Calendar.MINUTE), false
            )

            OutlinedTextField(
                value = wakeUpTime.value,
                onValueChange = {},
                label = {Text ("WakeUp Time")},
                shape = CircleShape,
                modifier = Modifier.padding(5.dp),
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Sharp.Alarm,
                        contentDescription = "WakeUp Time"
                    )
                },
                trailingIcon = {
                    Button(onClick = {wakeUpPickerDialog.show()},
                        colors = ButtonDefaults.buttonColors(backgroundColor = Blue),
                        shape = CircleShape,

                    ) {
                        Text(text = "Set")
                    }
                }
            )

            val calendar2 = Calendar.getInstance()
            val sleepTimeInMillis = remember { mutableStateOf(0L)}
            val sleepTime = remember { mutableStateOf("")}

            val sleepTimePickerDialog = TimePickerDialog(
                context,
                {_,
                 hour: Int ,
                 minute : Int ->
                    val sleepCalendar = Calendar.getInstance()
                    sleepCalendar.set(Calendar.HOUR_OF_DAY, hour)
                    sleepCalendar.set(Calendar.MINUTE, minute)
                    sleepTimeInMillis.value = sleepCalendar.timeInMillis
                    sleepTime.value = "$hour:$minute"
                }, calendar2.get(Calendar.HOUR_OF_DAY) , calendar2.get(Calendar.MINUTE), false
            )

            OutlinedTextField(
                value = sleepTime.value,
                onValueChange = {},
                label = {Text ("Sleeping Time")},
                shape = CircleShape,
                modifier = Modifier.padding(5.dp),
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Sharp.NightsStay,
                        contentDescription = "Height"
                    )
                },
                trailingIcon = {
                    Button(onClick = {sleepTimePickerDialog.show()},
                        colors = ButtonDefaults.buttonColors(backgroundColor = Blue),
                        shape = CircleShape,

                        ) {
                        Text(text = "Set")
                    }
                }
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(100.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                      loginViewModel.saveCredentials(name = name,age.toInt(),weight.toInt(),height.toInt(),wakeUpTimeInMillis.value,sleepTimeInMillis.value)
                        navController.popBackStack()
                        navController.navigate("navigation_bar")
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Blue),
                    shape = CircleShape,
                    elevation =  ButtonDefaults.elevation(
                        defaultElevation = 10.dp,
                        pressedElevation = 15.dp,
                        disabledElevation = 0.dp,
                    )
                    ) {
                    Text(
                        text = "Next",
                        color = Color.White
                    )
                }
            }
        }

    }
}



