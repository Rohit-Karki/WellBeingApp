package com.rohit.wellbeing.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rohit.wellbeing.model.WaterIntake
import com.rohit.wellbeing.repository.WaterIntakeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class ReminderViewModel @Inject constructor(private val waterIntakeRepository: WaterIntakeRepository) : ViewModel(){

    private val date :String = Date().date.toString()
    private val _waterIntakeQuantity:MutableStateFlow<WaterIntake> = MutableStateFlow(WaterIntake(0,0,date))
    val waterIntakeQuantity : StateFlow<WaterIntake> = _waterIntakeQuantity

    private val _progress :MutableStateFlow<Float> = MutableStateFlow(0f)
    val progress :StateFlow<Float> = _progress

    init{
        refresh()
    }

    @InternalCoroutinesApi
    fun refresh(){
        viewModelScope.launch {
            waterIntakeRepository
                .getWaterIntake(date)
                .collect { state ->
                    _waterIntakeQuantity.value = state
                    _progress.value = (waterIntakeQuantity.value.value.toFloat()/3600)
                }
        }
    }
    fun increaseWaterIntake(){
        viewModelScope.launch {
            waterIntakeRepository
                .updateWaterIntake(waterIntake = WaterIntake(0,waterIntakeQuantity.value.value+400,date))
        }
        _progress.value = (waterIntakeQuantity.value.value.toFloat()/3600)

    }



}