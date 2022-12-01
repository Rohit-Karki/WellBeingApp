package com.example.wellbeing.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.wellbeing.model.Step
import kotlinx.coroutines.flow.Flow

@Dao
interface StepDAO {
    @Query("SELECT * FROM step")
    fun getAll(): Flow<List<Step>>

    @Query("UPDATE step SET step_calorie= :step_calories, time =:time, distance =:distance where date = :date")
    suspend fun updateStep(date:String,step_calories: Int,time: Int,distance:Int)

    @Query("SELECT EXISTS(SELECT * FROM step WHERE date = :date)")
    suspend fun isDateExist(date: String): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStep(step: Step)

    @Query("SELECT * FROM step WHERE date = :date")
    fun getStep(date:String) : Flow<Step>
}