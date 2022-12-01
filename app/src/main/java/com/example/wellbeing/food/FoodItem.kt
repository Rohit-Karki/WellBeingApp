package com.example.wellbeing.food

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.filled.BorderRight
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wellbeing.R
import com.example.wellbeing.ViewModel.FoodViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodItem(viewModel: FoodViewModel){
    val isShown = remember{
        mutableStateOf(false)
    }
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

                    var text = remember { mutableStateOf(TextFieldValue("")) }
                    OutlinedTextField(
                        value = text.value,
                        onValueChange = { newText ->
                            text.value = newText
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    )
                    Text(text = "g")
                }
                Button(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Done, contentDescription = "Tick Right")
                }

            }
        }
    }
}