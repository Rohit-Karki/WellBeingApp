package com.rohit.wellbeing.di.module

import android.app.Application
import com.rohit.wellbeing.sensor.MeasurableSensor
import com.rohit.wellbeing.sensor.StepCountSensor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SensorModule {

    @Provides
    @Singleton
    fun provideLightSensor(app: Application): MeasurableSensor {
        return StepCountSensor(app)
    }

}