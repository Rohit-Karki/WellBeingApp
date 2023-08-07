package com.rohit.wellbeing

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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rohit.wellbeing.R
import com.rohit.wellbeing.ViewModel.LoginViewModel


@Composable
fun SplashScreen(navController : NavController){

    val loginViewModel = hiltViewModel<LoginViewModel>()
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
        navController.popBackStack()
        if(loginViewModel.readFirstTime()){
            navController.navigate("navigation_bar")
        }
        else{
            navController.navigate("login_form")
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

