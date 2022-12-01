package com.example.wellbeing.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wellbeing.model.FoodCalorie
import com.example.wellbeing.model.NetworkState
import com.example.wellbeing.repository.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(val foodRepository: FoodRepository) :ViewModel(){
    private val date :String = Date().date.toString()
    private val _foodCalorie : MutableStateFlow<FoodCalorie> = MutableStateFlow(FoodCalorie(0,0,0,0,0,date))
    var foodCalorie :StateFlow<FoodCalorie> = _foodCalorie

    init {
        refresh()
    }

    private fun refresh(){
        viewModelScope.launch {
            foodRepository
                .getFoodCalorie(date)
                .collect { state ->
                    _foodCalorie.value = state
                }
        }
    }
    fun addCalories(totalCalories:Long,carbs:Long,proteins:Long,fats:Long){
        viewModelScope.launch {
            foodRepository.updateWaterIntake(
                foodCalorie = FoodCalorie(0,totalCalories,proteins,carbs,fats,date)
            )
        }
    }
}