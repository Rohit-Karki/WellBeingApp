package com.rohit.wellbeing.settings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions


object SettingsTab: Tab, AndroidScreen(){
    override val options: TabOptions
        @Composable
        get()  {
            val title = "Settings"
            val icon = rememberVectorPainter(Icons.Default.Settings)

            return remember {
                TabOptions(
                    4u,
                    title, icon
                )
            }
        }

    @Composable
    override fun Content() {
        SettingScreen()
    }
}