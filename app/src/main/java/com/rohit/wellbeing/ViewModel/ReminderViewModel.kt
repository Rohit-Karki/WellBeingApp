package com.rohit.wellbeing.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rohit.wellbeing.model.WaterIntake
import com.rohit.wellbeing.model.NetworkState
import com.rohit.wellbeing.repository.WaterIntakeRepository
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject


@InternalCoroutinesApi
class ReminderViewModel @Inject constructor(private val waterIntakeRepository: WaterIntakeRepository) : ViewModel(){

    private val _waterIntakeQuantity:MutableStateFlow<NetworkState<WaterIntake>> = MutableStateFlow(NetworkState.loading())
    val waterIntakeQuantity : StateFlow<NetworkState<WaterIntake>> = _waterIntakeQuantity
    private val date :String = Date().toString()

    init{
        refresh()
    }

    @InternalCoroutinesApi
    fun refresh(){
        viewModelScope.launch {
            waterIntakeRepository
                .getWaterIntake(date)
                .collect { state ->
                    _waterIntakeQuantity.value = NetworkState.Success(state)
                }
        }
    }

}