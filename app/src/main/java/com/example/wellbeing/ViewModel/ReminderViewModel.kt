package com.example.wellbeing.ViewModel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

//import com.example.wellbeing.model.State
//import com.example.wellbeing.model.WaterIntake
//import com.example.wellbeing.repository.WaterIntakeRepository
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlinx.coroutines.flow.collect
//@InternalCoroutinesApi
//class ReminderViewModel @Inject constructor(private val waterIntakeRepository: WaterIntakeRepository) : ViewModel(){
//
//    private val _waterIntakeQuantity:MutableStateFlow<State<WaterIntake>> = MutableStateFlow(State.loading())
//    val waterIntakeQuantity : StateFlow<State<WaterIntake>> = _waterIntakeQuantity
//    private val date :String = Date().toString()
//
//    init{
//        refresh()
//    }
//
//    @InternalCoroutinesApi
//    fun refresh(){
//        viewModelScope.launch {
//            waterIntakeRepository
//                .getWaterIntake(date)
//                .collect { state ->
//                    _waterIntakeQuantity.value = State.Success(state)
//                }
//
//        }
//    }
//
//}