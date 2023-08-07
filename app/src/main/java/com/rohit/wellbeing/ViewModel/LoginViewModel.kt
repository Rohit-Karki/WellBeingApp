package com.rohit.wellbeing.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rohit.wellbeing.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) : ViewModel() {

    fun saveCredentials(name:String, age :Int, weight :Int, height :Int, wakeUpTime :Long,sleepTime: Long){
    viewModelScope.launch(Dispatchers.IO) {
        loginRepository.saveCredentials(name, age, weight, height, wakeUpTime, sleepTime)
    }
    }

    suspend fun readFirstTime(): Boolean = loginRepository.readCredentials()


}