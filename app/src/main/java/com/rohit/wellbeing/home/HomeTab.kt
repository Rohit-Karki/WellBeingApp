package com.rohit.wellbeing.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
<<<<<<< HEAD:app/src/main/java/com/example/wellbeing/home/HomeTab.kt
import com.rohit.wellbeing.viewModel.FoodViewModel
import com.rohit.wellbeing.viewModel.MainViewModel
import com.rohit.wellbeing.viewModel.ReminderViewModel
import kotlinx.coroutines.InternalCoroutinesApi
=======
>>>>>>> 1134a61015c2df604f792be88aa027f6f5acadd5:app/src/main/java/com/rohit/wellbeing/home/HomeTab.kt

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