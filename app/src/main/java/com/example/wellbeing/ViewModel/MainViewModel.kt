package com.example.wellbeing.ViewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.wellbeing.sensor.MeasurableSensor

//import com.example.wellbeing.sensors.MeasurableSensor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val stepSensor: MeasurableSensor
) :ViewModel() {
    private val _stepCount :MutableStateFlow<Float> = MutableStateFlow<Float>(0f)
    val stepCount :StateFlow<Float> = _stepCount

    private val _isRunning :MutableStateFlow<Boolean> = MutableStateFlow<Boolean>(true)
    val isRunning :StateFlow<Boolean> = _isRunning

    init {
        _isRunning.value = true
        startListening()
    }

    fun stopListening(){
        _isRunning.value = false
        stepSensor.stopListening()
    }
    fun startListening(){
        _isRunning.value = true
        stepSensor.startListening()
        stepSensor.setOnSensorValuesChangedListener { values->
            _stepCount.value = values[0]
        }
    }



}

