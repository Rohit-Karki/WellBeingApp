package com.example.wellbeing.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wellbeing.model.FoodCalorie

@Database(
    entities = [FoodCalorie::class],
    version = 1,
    exportSchema = false
)
abstract class FoodDatabase :RoomDatabase(){
    abstract fun getFoodDAO() :FoodDAO
}