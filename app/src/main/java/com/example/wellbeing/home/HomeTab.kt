package com.example.wellbeing.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.wellbeing.ViewModel.FoodViewModel
import com.example.wellbeing.ViewModel.MainViewModel
import com.example.wellbeing.ViewModel.ReminderViewModel
import com.example.wellbeing.custom.Screen
import kotlinx.coroutines.InternalCoroutinesApi

object HomeTab : Tab, AndroidScreen() {

    override val options: TabOptions
        @Composable
        get()  {
            val title = "Home"
            val icon = rememberVectorPainter(Icons.Default.Home)

            return remember {
                TabOptions(
                    0u,
                    title, icon
                )
            }
        }

    @OptIn(InternalCoroutinesApi::class)
    @Composable
    override fun Content() {
        val mainViewModel = getViewModel<MainViewModel>()
        val reminderViewModel = getViewModel<ReminderViewModel>()
        val foodViewModel = getViewModel<FoodViewModel>()

        HomeScreen(mainViewModel,reminderViewModel,foodViewModel)
    }
}