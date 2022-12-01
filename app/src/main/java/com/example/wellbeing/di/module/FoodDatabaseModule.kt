package com.example.wellbeing.di.module

import android.content.Context
import androidx.room.Room
import com.example.fitness_app.database.WaterIntakeDAO
import com.example.fitness_app.database.WaterIntakeDatabase
import com.example.wellbeing.database.FoodDAO
import com.example.wellbeing.database.FoodDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FoodDatabaseModule {
    @Singleton
    @Provides
    fun provideFoodDAO (database: FoodDatabase): FoodDAO {
        return database.getFoodDAO()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) : FoodDatabase {
        return Room
            .databaseBuilder(
                appContext,
                FoodDatabase::class.java,
                "FitnessApp").
            build()
    }

}