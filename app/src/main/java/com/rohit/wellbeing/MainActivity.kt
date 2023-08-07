package com.rohit.wellbeing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.tab.*
import com.rohit.wellbeing.Exercise.ExerciseTab
import com.rohit.wellbeing.water.WaterScreenTab
import com.rohit.wellbeing.food.FoodTab
import com.rohit.wellbeing.home.HomeTab
import com.rohit.wellbeing.screens.*
import com.rohit.wellbeing.settings.SettingsTab
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
