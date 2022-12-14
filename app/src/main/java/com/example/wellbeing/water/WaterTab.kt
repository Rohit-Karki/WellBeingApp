package com.example.wellbeing

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Water
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.wellbeing.screens.WaterScreen

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

    @Composable
    override fun Content() {
        WaterScreen()
    }
}
