package com.example.wellbeing.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wellbeing.R
import com.example.wellbeing.ViewModel.FoodViewModel
import com.example.wellbeing.ViewModel.MainViewModel
import com.example.wellbeing.ViewModel.ReminderViewModel
import com.example.wellbeing.model.FoodCalorie
import com.example.wellbeing.model.NetworkState
import kotlinx.coroutines.InternalCoroutinesApi

@OptIn(InternalCoroutinesApi::class)
@Composable
fun HomeScreen(viewModel: MainViewModel,reminderViewModel: ReminderViewModel,foodViewModel: FoodViewModel) {
    Column() {
        StepScreen(viewModel = viewModel)
        GridItems(reminderViewModel,foodViewModel)
    }
}

@OptIn(InternalCoroutinesApi::class)
@Composable
fun GridItems(reminderViewModel: ReminderViewModel,foodViewModel: FoodViewModel){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
            WaterBox(reminderViewModel)
            CalorieBox(foodViewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class, InternalCoroutinesApi::class)
@Composable
fun WaterBox(reminderViewModel: ReminderViewModel){
    val waterIntake = reminderViewModel.waterIntakeQuantity.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(20.dp)
    ) {
        Card(
            modifier = Modifier
                .width(140.dp)
                .height(200.dp),
            elevation = 4.dp,
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.water), contentDescription = "Water"
            )
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {
                Text("Water", fontWeight = FontWeight.ExtraBold)
                Spacer(modifier = Modifier.height(100.dp))
                Text(waterIntake.value.value.toString(), fontWeight = FontWeight.Bold)
                Text("Daily Goal 3.6l", fontWeight = FontWeight.Light)
            }
        }
    }
}

@OptIn(InternalCoroutinesApi::class)
@Composable
fun CalorieBox(foodViewModel: FoodViewModel){
    val foodCalorie = foodViewModel.foodCalorie.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(20.dp)
    ) {
        Card(
            modifier = Modifier
                .width(140.dp)
                .height(200.dp),
            elevation = 4.dp,
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.dmitrynew200800035), contentDescription = "Calorie Burn"
            )
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {
                Text("Calorie Intake", fontWeight = FontWeight.ExtraBold)
                Spacer(modifier = Modifier.height(100.dp))
                Text(foodCalorie.value.totalCalories.toString() + " kcal", fontWeight = FontWeight.Bold)
//                Text("100" + " kcal", fontWeight = FontWeight.Bold)
                Text("Daily Goal 450kcal", fontWeight = FontWeight.Light)
            }
        }
    }
}