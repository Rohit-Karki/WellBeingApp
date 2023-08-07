package com.example.wellbeing

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.fitness_app.composable.DataFormScreen
import com.example.wellbeing.ViewModel.LoginViewModel

object SplashScreenPage :AndroidScreen(){
    @Composable
    override fun Content() {
        val loginViewModel = getViewModel<LoginViewModel>()
        SplashScreen(loginViewModel)
    }

}

@Composable
fun SplashScreen(loginViewModel: LoginViewModel){
    val navController = LocalNavigator.currentOrThrow

    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }
            )
        )
        if(loginViewModel.readFirstTime()){
            navController.popAll()
            navController.push(HomeNavigationScreen)
        }
        else{
            navController.popAll()
            navController.push(DataFormScreen)
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    )
    {
        Image(
            painter = painterResource(id = R.drawable.ic_android_small___1),
            contentDescription = "logo",
            modifier = Modifier.scale(scale.value)
        )
    }
}

