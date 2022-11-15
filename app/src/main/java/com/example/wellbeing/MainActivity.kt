package com.example.wellbeing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.*
import com.example.wellbeing.Exercise.ExerciseTab
import com.example.wellbeing.food.FoodTab
import com.example.wellbeing.home.HomeTab
import com.example.wellbeing.screens.*
import com.example.wellbeing.settings.SettingsTab
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent {
                Surface(color = Color(0xFF202020), modifier = Modifier.fillMaxSize()) {
                    TabNavigator(tab = HomeTab){
                        Scaffold(
                            bottomBar = {
                                BottomNavigation{
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
    }
}

@Composable
fun RowScope.TabNavigationItems(tab: Tab) {

    val tabNavigator = LocalTabNavigator.current
    BottomNavigationItem(selected = tabNavigator.current == tab, onClick = { tabNavigator.current = tab },
        icon = { Icon(tab.options.icon!!, contentDescription = tab.options.title ) }
    )

}
