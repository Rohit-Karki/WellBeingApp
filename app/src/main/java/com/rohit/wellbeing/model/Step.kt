package com.rohit.wellbeing.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "step")
data class Step(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    @ColumnInfo(name = "step_calorie") var step_calories: Int,
    @ColumnInfo(name = "distance") val distance: Int,
    @ColumnInfo(name = "time") val time: Int,
    @ColumnInfo(name = "date") val date: String,
)
