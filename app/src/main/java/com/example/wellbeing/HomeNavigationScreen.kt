package com.example.wellbeing

import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.wellbeing.Exercise.ExerciseTab
import com.example.wellbeing.food.FoodTab
import com.example.wellbeing.home.HomeTab
import com.example.wellbeing.settings.SettingsTab

object HomeNavigationScreen:AndroidScreen() {
    @Composable
    override fun Content() {
        TabNavigator(tab = HomeTab){
            Scaffold(
                bottomBar = {
                    NavigationBar(){
                        TabNavigationItems(tab = HomeTab)
                        TabNavigationItems(tab = WaterScreenTab)
                        TabNavigationItems(tab = ExerciseTab)
                        TabNavigationItems(tab = FoodTab)
                        TabNavigationItems(tab = SettingsTab)
                    }
                }
            ) {
                CurrentTab()
            }
        }
    }
}