package com.rohit.wellbeing.food

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rohit.wellbeing.viewModel.FoodViewModel

@Composable
fun BreakfastScreen(foodViewModel: FoodViewModel) {
    Column {
        FoodItem(foodViewModel)
        Spacer(modifier = Modifier.height(10.dp))
        FoodItem(foodViewModel)
        Spacer(modifier = Modifier.height(10.dp))
        FoodItem(foodViewModel)
        Spacer(modifier = Modifier.height(10.dp))
        FoodItem(foodViewModel)
        Spacer(modifier = Modifier.height(10.dp))
        FoodItem(foodViewModel)
    }
}

