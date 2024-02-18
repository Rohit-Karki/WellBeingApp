package com.rohit.wellbeing.repository

import com.rohit.wellbeing.database.WaterIntakeDAO
import com.rohit.wellbeing.model.WaterIntake
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WaterIntakeRepository @Inject constructor(private val waterIntakeDAO: WaterIntakeDAO){

    suspend fun getWaterIntake(date:String): Flow<WaterIntake> {
        if(!waterIntakeDAO.isDateExist(date)) {
            waterIntakeDAO.insertWaterIntake(waterIntake = WaterIntake(0,0,date))
        }
        return waterIntakeDAO.getWaterIntake(date)
    }

    suspend fun updateWaterIntake(waterIntake: WaterIntake){
        if(!waterIntakeDAO.isDateExist(waterIntake.date)) {
            waterIntakeDAO.insertWaterIntake(waterIntake = waterIntake)
        }
        else {
            waterIntakeDAO.updateWaterIntake(waterIntake.date, waterIntake.value)
        }
    }
}