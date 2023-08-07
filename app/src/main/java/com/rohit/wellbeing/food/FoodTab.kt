package com.rohit.wellbeing.food

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.rohit.wellbeing.ViewModel.FoodViewModel


object FoodTab : Tab, AndroidScreen() {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Home"
            val icon = rememberVectorPainter(Icons.Default.Fastfood)

            return remember {
                TabOptions(
                    3u,
                    title, icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(screen = FoodListScreen())
    }
}

class FoodListScreen : Screen,AndroidScreen() {

    @Composable
    private fun GoToFoodTabButton() {
        val tabNavigator = LocalTabNavigator.current

        Button(
            onClick = { tabNavigator.current = FoodTab }
        ){
            Text(text = "Food Tab")
        }
    }

    @Composable
    override fun Content() {
        val screenModel = getViewModel<FoodViewModel>()
        FoodScreen(foodViewModel = screenModel)
    }
}

object BreakFastDetailScreen :Screen{

    @Composable
    override fun Content(){
        val screenModel = getViewModel<FoodViewModel>()
        BreakfastScreen(screenModel)
    }
}

object LunchDetailScreen :Screen{
    @Composable
    override fun Content(){
//        BreakfastScreen()
    }
}

object DinnerDetailScreen :Screen{
    @Composable
    override fun Content(){
//        BreakfastScreen()
    }
}
