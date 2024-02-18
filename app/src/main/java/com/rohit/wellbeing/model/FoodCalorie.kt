package com.rohit.wellbeing.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="foodcalorie")
data class FoodCalorie(
    @PrimaryKey(autoGenerate = true)
    val uid: Int=0,
    @ColumnInfo(name = "totalCalorie") val totalCalories: Long,
    @ColumnInfo(name = "proteins") val proteins: Long,
    @ColumnInfo(name = "carbs") val carbs: Long,
    @ColumnInfo(name = "fats") val fats: Long,
    @ColumnInfo(name= "date") val date: String
)

