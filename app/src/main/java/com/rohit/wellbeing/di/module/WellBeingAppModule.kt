package com.rohit.wellbeing.di.module

import android.content.Context
import androidx.room.Room
import com.rohit.wellbeing.database.StepDAO
import com.rohit.wellbeing.database.WellBeingAppDatabase
import com.rohit.wellbeing.database.FoodDAO
import com.rohit.wellbeing.database.WaterIntakeDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WellBeingAppModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): WellBeingAppDatabase {
        return Room
            .databaseBuilder(
                appContext,
                WellBeingAppDatabase::class.java,
                "WellbeingApp"
            ).build()
    }

    @Singleton
    @Provides
    fun provideWaterIntakeDAO(database: WellBeingAppDatabase): WaterIntakeDAO {
        return database.getWaterIntakeDao()
    }

    @Singleton
    @Provides
    fun provideStepDAO(database: WellBeingAppDatabase): StepDAO {
        return database.getStepDAO()
    }

    @Singleton
    @Provides
    fun provideFoodDAO (database: WellBeingAppDatabase): FoodDAO {
        return database.getFoodDAO()
    }
}