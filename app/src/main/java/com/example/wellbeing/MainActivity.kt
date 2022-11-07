package com.example.wellbeing

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.wellbeing.model.OnboardPages
import dagger.hilt.android.AndroidEntryPoint

import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent {
                Surface(color = Color(0xFF202020), modifier = Modifier.fillMaxSize()) {
                    Navigation()
//                    OnBoardingPage(page = OnboardPages[0])
                }
            }
    }
}


