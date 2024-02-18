package com.rohit.wellbeing

import androidx.compose.material.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.rohit.wellbeing.Exercise.ExerciseTab
import com.rohit.wellbeing.food.FoodTab
import com.rohit.wellbeing.home.HomeTab
import com.rohit.wellbeing.settings.SettingsTab
import com.rohit.wellbeing.water.WaterScreenTab

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