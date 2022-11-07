package com.example.wellbeing.ViewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.wellbeing.sensor.MeasurableSensor

//import com.example.wellbeing.sensors.MeasurableSensor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val stepSensor: MeasurableSensor
) :ViewModel() {
    var stepCount = mutableStateOf<Float>(0f)
    var isRunning = mutableStateOf<Boolean>(false)

    init {
        Log.d("Step Sensor", "init")
        isRunning.value = true
        stepSensor.startListening()
        stepSensor.setOnSensorValuesChangedListener { values ->
            Log.d("Step Sensor", "value is ${values}")
            stepCount.value = values[0]
        }
    }
}

