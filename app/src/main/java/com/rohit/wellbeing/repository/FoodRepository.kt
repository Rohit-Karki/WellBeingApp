package com.rohit.wellbeing.repository

import com.rohit.wellbeing.database.FoodDAO
import com.rohit.wellbeing.model.FoodCalorie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FoodRepository @Inject constructor(private val foodDAO: FoodDAO) {
     suspend fun getFoodCalorie(date:String): Flow<FoodCalorie> {
        if(!foodDAO.isDateExist(date)) {
            foodDAO.insertFoodCalorie(foodCalorie = FoodCalorie(0,0,0,0,0,date))
        }
        return foodDAO.getFoodCalorie(date)
    }

    suspend fun updateWaterIntake(foodCalorie: FoodCalorie){
        if(!foodDAO.isDateExist(foodCalorie.date)) {
            foodDAO.insertFoodCalorie(foodCalorie = foodCalorie)
        }
        else {
            foodDAO.updateFoodCalorie(foodCalorie.date, foodCalorie.totalCalories,foodCalorie.proteins,foodCalorie.fats,foodCalorie.carbs)
        }
    }


}