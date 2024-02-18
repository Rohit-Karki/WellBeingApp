package com.rohit.wellbeing.repository

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject


private val Context.dataStore by preferencesDataStore("app_preferences")

class LoginRepository @Inject constructor(context: Context) {

    companion object {
        val nameKey = stringPreferencesKey("name")
        val ageKey = intPreferencesKey("age")
        val weightKey = intPreferencesKey("weight")
        val heightKey = intPreferencesKey("height")
        val wakeUpTimeKey = longPreferencesKey("wakeUpTime")
        val sleepTimeKey = longPreferencesKey("sleepTime")
        val isFirstTime = booleanPreferencesKey("isFirstTime")
    }

    private val dataStore = context.dataStore
    suspend fun saveCredentials(name:String, age :Int, weight :Int, height :Int, wakeUpTime :Long,sleepTime: Long){
        dataStore.edit { preferences ->
            preferences[nameKey] = name
            preferences[ageKey] = age
            preferences[weightKey] = weight
            preferences[heightKey] = height
            preferences[wakeUpTimeKey] = wakeUpTime
            preferences[sleepTimeKey] = sleepTime
            preferences[isFirstTime] = true
        }
    }

    suspend fun readCredentials() :Boolean{
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val isFirstTime = preferences[isFirstTime] ?: false
                isFirstTime
            }.first()
    }
}