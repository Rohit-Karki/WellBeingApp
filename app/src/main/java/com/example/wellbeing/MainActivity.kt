package com.example.wellbeing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.*
import com.example.wellbeing.screens.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent {
                Surface(color = Color(0xFF202020), modifier = Modifier.fillMaxSize()) {
                    Navigator(
                     SplashScreenPage
                    )
                }
            }
    }
}

@Composable
fun RowScope.TabNavigationItems(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    BottomNavigationItem(
        selected = tabNavigator.current == tab, onClick = { tabNavigator.current = tab },
        modifier = Modifier
            .align(Alignment.CenterVertically),
        icon = { Icon(
            tab.options.icon!!,
            contentDescription = tab.options.title,
            modifier = Modifier
                .padding(
                    horizontal = 15.dp,
                    vertical = 10.dp
                )
                .fillMaxWidth()
                .background(color =
            if(tabNavigator.current == tab)
                Color(232,222,248)
            else
                Color.Transparent,
                    shape = androidx.compose.material3.Shapes.Full
            ),
        ) },
        label = {->
            Text(
                text = tab.options.title,
                style = TextStyle(
                    color = Color.Black
                )
            )
        },
        alwaysShowLabel = true,
    )
}
