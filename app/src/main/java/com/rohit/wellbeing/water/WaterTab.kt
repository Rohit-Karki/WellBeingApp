package com.rohit.wellbeing.water

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Water
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.rohit.wellbeing.viewModel.ReminderViewModel

import kotlinx.coroutines.InternalCoroutinesApi

object WaterScreenTab : Tab, AndroidScreen() {
    override val options: TabOptions
        @Composable
        get()  {
            val title = "Water"
            val icon = rememberVectorPainter(Icons.Default.Water)

            return remember {
                TabOptions(
                    1u,
                    title, icon
                )
            }
        }


    @OptIn(InternalCoroutinesApi::class)
    @Composable
    override fun Content() {
        val screenModel = getViewModel<ReminderViewModel>()
        WaterScreen(screenModel)
    }
}
