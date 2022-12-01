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

    private val _foodCalorie : MutableStateFlow<NetworkState<FoodCalorie>> = MutableStateFlow(NetworkState.loading())
    var foodCalorie :StateFlow<NetworkState<FoodCalorie>> = _foodCalorie
    private val date :String = Date().toString()

    init {
        refresh()
    }

    private fun refresh(){
        viewModelScope.launch {
            foodRepository
                .getFoodCalorie(date)
                .collect { state ->
                    _foodCalorie.value = NetworkState.success(data = state)
                }
        }
    }
}