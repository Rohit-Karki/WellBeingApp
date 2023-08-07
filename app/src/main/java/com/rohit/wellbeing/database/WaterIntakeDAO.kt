package com.rohit.wellbeing.database

import androidx.room.*
import com.rohit.wellbeing.model.WaterIntake
import kotlinx.coroutines.flow.Flow

@Dao
interface WaterIntakeDAO {
    @Query("SELECT * FROM waterIntake")
    fun getAll(): Flow<List<WaterIntake>>

    @Query("UPDATE waterintake SET value = :value where date = :date")
    suspend fun updateWaterIntake(date:String,value: Long)

    @Query("SELECT EXISTS(SELECT * FROM waterintake WHERE date = :date)")
    suspend fun isDateExist(date: String): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWaterIntake(waterIntake: WaterIntake)

    @Query("SELECT * FROM waterintake WHERE date = :date")
    fun getWaterIntake(date:String) : Flow<WaterIntake>
}