package com.rohit.wellbeing.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rohit.wellbeing.model.FoodCalorie
import com.rohit.wellbeing.model.Step
import com.rohit.wellbeing.model.WaterIntake

@Database(
    entities = [WaterIntake::class, FoodCalorie::class, Step::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class WellBeingAppDatabase: RoomDatabase() {
    abstract fun getWaterIntakeDao(): WaterIntakeDAO
    abstract fun getFoodDAO() :FoodDAO
    abstract fun getStepDAO() : StepDAO
}