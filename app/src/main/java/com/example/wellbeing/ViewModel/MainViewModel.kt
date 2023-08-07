package com.example.wellbeing.ViewModel


import android.icu.text.SimpleDateFormat
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wellbeing.model.NetworkState
import com.example.wellbeing.model.Step
import com.example.wellbeing.repository.StepRepository
import com.example.wellbeing.sensor.MeasurableSensor

//import com.example.wellbeing.sensors.MeasurableSensor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.String.format
import java.time.LocalDate
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val stepSensor: MeasurableSensor,
    private val stepRepository: StepRepository
) :ViewModel() {

    private val _isRunning :MutableStateFlow<Boolean> = MutableStateFlow<Boolean>(true)
    val isRunning :StateFlow<Boolean> = _isRunning

    private val date :String = Date().date.toString()

    private val _totalSteps :MutableStateFlow<Step> = MutableStateFlow(Step(0,0,0,0,date))
    val totalSteps :StateFlow<Step>  = _totalSteps.asStateFlow()

    init {
        refresh()
        startListening()
    }

    private fun refresh(){
        viewModelScope.launch {
            stepRepository
                .getStep(date)
                .collect { state ->
                    _totalSteps.value = state
                }
        }
    }

    fun stopListening(){
        viewModelScope.launch {
            stepRepository.updateStep(
                Step(0,totalSteps.value.step_calories,0,0,date)
            )
        }
        _isRunning.value = false
        stepSensor.stopListening()
    }
    fun startListening(){
        _isRunning.value = true
        stepSensor.startListening()
        stepSensor.setOnSensorValuesChangedListener { values->
            Log.d("setonsensor",totalSteps.toString())
            _totalSteps.update {step->
                Step(0,step.step_calories+1,0,0,date)
            }
//            _totalSteps.value = _totalSteps.value.copy(step_calories = _totalSteps.value.step_calories+1)
        }
    }
}

