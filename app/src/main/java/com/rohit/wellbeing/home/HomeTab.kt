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
import com.rohit.wellbeing.ViewModel.MainViewModel

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

    @Composable
    override fun Content() {
        val screenModel = getViewModel<MainViewModel>()
        StepScreen(screenModel)
    }
}