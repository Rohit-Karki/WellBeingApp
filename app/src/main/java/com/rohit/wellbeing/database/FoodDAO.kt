package com.rohit.wellbeing.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rohit.wellbeing.model.FoodCalorie
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDAO {
    @Query("SELECT * FROM foodcalorie")
    fun getAll(): Flow<List<FoodCalorie>>

    @Query("UPDATE foodcalorie SET totalCalorie= :totalCalorie, proteins= :proteins, carbs =:carbs,fats =:fats where date = :date")
    suspend fun updateFoodCalorie(date:String,totalCalorie: Long,proteins :Long,fats :Long,carbs :Long)

    @Query("SELECT EXISTS(SELECT * FROM foodcalorie WHERE date = :date)")
    suspend fun isDateExist(date: String): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoodCalorie(foodCalorie: FoodCalorie)

    @Query("SELECT * FROM foodcalorie WHERE date = :date")
    fun getFoodCalorie(date:String) : Flow<FoodCalorie>
}