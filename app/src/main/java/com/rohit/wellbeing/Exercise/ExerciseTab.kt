package com.rohit.wellbeing.Exercise

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
<<<<<<< HEAD:app/src/main/java/com/example/wellbeing/Exercise/ExerciseTab.kt
=======
import com.rohit.wellbeing.model.ExerciseData

>>>>>>> 1134a61015c2df604f792be88aa027f6f5acadd5:app/src/main/java/com/rohit/wellbeing/Exercise/ExerciseTab.kt

object ExerciseTab : Tab, AndroidScreen() {

    override val options: TabOptions
        @Composable
        get() {
            val title = "Exercise"
            val icon = rememberVectorPainter(Icons.Default.FitnessCenter)

            return remember {
                TabOptions(
                    2u,
                    title,
                    icon
                )
            }

        }

    @Composable
    override fun Content() {
        Navigator(ExerciseListScreen())
    }

}


class ExerciseListScreen : Screen,AndroidScreen() {

    @Composable
    private fun GoToProfileTabButton() {
        val tabNavigator = LocalTabNavigator.current

        Button(
            onClick = { tabNavigator.current = ExerciseTab }
        ){
            Text(text = "DailyScreenTab")
        }
    }

    @Composable
    override fun Content() {
        Exercise()
    }
}

data class ExerciseDetailsScreen(val data: ExerciseData) : Screen {
    @Composable
    override fun Content() {
        ExerciseGridUI(data)
    }
}


