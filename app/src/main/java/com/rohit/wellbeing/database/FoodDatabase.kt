package com.rohit.wellbeing.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rohit.wellbeing.model.FoodCalorie

@Database(
    entities = [FoodCalorie::class],
    version = 1,
    exportSchema = false
)
abstract class FoodDatabase :RoomDatabase(){
    abstract fun getFoodDAO() :FoodDAO
}