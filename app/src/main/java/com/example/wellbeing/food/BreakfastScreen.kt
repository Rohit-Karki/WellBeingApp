package com.example.wellbeing.food

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wellbeing.ViewModel.FoodViewModel

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

