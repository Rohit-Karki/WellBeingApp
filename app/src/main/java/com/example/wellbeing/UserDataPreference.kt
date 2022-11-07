package com.example.wellbeing

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore("app_preferences")

class UserDataPreference @Inject constructor(context:Context) {

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
    suspend fun saveCredentials(key:String, name:String, age :Int, weight :Int, height :Int, wakeUpTime :Long,sleepTime: Long){
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
}