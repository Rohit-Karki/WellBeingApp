package com.rohit.wellbeing.food

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
<<<<<<< HEAD:app/src/main/java/com/example/wellbeing/food/FoodItem.kt
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.rohit.wellbeing.R
import com.rohit.wellbeing.viewModel.FoodViewModel

=======
>>>>>>> 1134a61015c2df604f792be88aa027f6f5acadd5:app/src/main/java/com/rohit/wellbeing/food/FoodItem.kt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodItem(viewModel: FoodViewModel){
    val navigator = LocalNavigator.currentOrThrow
    val foodCalorie = viewModel.foodCalorie.collectAsState()
    val isShown = remember{
        mutableStateOf(false)
    }
    var text = remember { mutableStateOf(TextFieldValue("")) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable {
                isShown.value = !isShown.value
            }
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.lunges), contentDescription = "Rice",
//                modifier = Modifier.width(40.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
                ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Rice food", fontWeight = FontWeight.Bold )
                    Text(text = "540kcal / 1000 g", fontSize = 10.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column() {
                    Text("60 g",fontWeight = FontWeight.Bold)
                    Text(text = "Carbs", fontSize = 10.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column() {
                    Text("8 g",fontWeight = FontWeight.Bold)
                    Text(text = "Protein", fontSize = 10.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column() {
                    Text("8 g", fontWeight = FontWeight.Bold)
                    Text(text = "Fats", fontSize = 10.sp)
                }
            }
            Spacer(modifier = Modifier.width(5.dp))
        }
        if(isShown.value) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = text.value,
                        onValueChange = { newText ->
                            text.value = newText
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    )
                    Text(text = "g")
                }
                Button(onClick = {
                    val totalCalories = text.value.text.toInt() * 540/1000
                    viewModel.addCalories(totalCalories.toLong(),8,60,8)
                    navigator.pop()
                }) {
                    Icon(Icons.Default.Done, contentDescription = "Tick Right")
                }

            }
        }
    }
}