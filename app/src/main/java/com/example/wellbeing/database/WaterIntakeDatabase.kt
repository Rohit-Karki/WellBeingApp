package com.example.fitness_app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.wellbeing.model.WaterIntake

@Database(
    entities = [WaterIntake::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class WaterIntakeDatabase :RoomDatabase() {
    abstract fun getWaterIntakeDao(): WaterIntakeDAO


    // Without Dependency injection database builder

//    companion object {
//        @Volatile
//        private var instance: WaterIntakeDatabase? = null
//        private val LOCK = Any()
//
//        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
//            instance ?: createDatabase(context).also { instance = it }
//        }
//
//        private fun createDatabase(context: Context) =
//            Room.databaseBuilder(
//                context.applicationContext,
//                WaterIntakeDatabase::class.java,
//                "article_db.db"
//            ).build()
//
//    }
}