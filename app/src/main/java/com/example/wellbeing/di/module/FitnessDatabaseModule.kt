package com.example.fitness_app.di.module

import android.content.Context
import androidx.room.Room
import com.example.fitness_app.database.WaterIntakeDAO
import com.example.fitness_app.database.WaterIntakeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object FitnessDatabaseModule {
    @Singleton
    @Provides
    fun provideWaterIntakeDAO (database: WaterIntakeDatabase): WaterIntakeDAO {
        return database.getWaterIntakeDao()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) :WaterIntakeDatabase {
        return Room
            .databaseBuilder(
                appContext,
                WaterIntakeDatabase::class.java,
                "FitnessApp").
            build()
    }

}