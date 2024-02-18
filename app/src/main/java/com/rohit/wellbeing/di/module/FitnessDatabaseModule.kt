package com.rohit.wellbeing.di.module

import android.content.Context
import androidx.room.Room
import com.rohit.wellbeing.database.WaterIntakeDAO
import com.rohit.wellbeing.database.WaterIntakeDatabase
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
}