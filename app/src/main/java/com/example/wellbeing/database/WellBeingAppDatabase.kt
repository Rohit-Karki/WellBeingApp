package com.example.wellbeing.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fitness_app.database.Converters
import com.example.fitness_app.database.WaterIntakeDAO
import com.example.wellbeing.model.FoodCalorie
import com.example.wellbeing.model.Step
import com.example.wellbeing.model.WaterIntake

@Database(
    entities = [WaterIntake::class, FoodCalorie::class,Step::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class WellBeingAppDatabase: RoomDatabase() {
    abstract fun getWaterIntakeDao(): WaterIntakeDAO
    abstract fun getFoodDAO() :FoodDAO
    abstract fun getStepDAO() :StepDAO
}