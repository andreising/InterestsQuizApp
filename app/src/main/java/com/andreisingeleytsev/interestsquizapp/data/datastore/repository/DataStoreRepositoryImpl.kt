package com.andreisingeleytsev.interestsquizapp.data.datastore.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.andreisingeleytsev.interestsquizapp.domain.datastore.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class DataStoreRepositoryImpl(context: Context): DataStoreRepository {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "beauty_app_pref")
    private object PreferencesKeys {
        val onBoardingKey = booleanPreferencesKey(name = "on_boarding_completed")
        val onBoardingCategoryKey = stringPreferencesKey(name = "datastore_category")
    }

    private val dataStore = context.dataStore


    override suspend fun getFavouritesCategories(): Flow<List<Int>> {
        return dataProvide().map { preferences ->
                val string = preferences[PreferencesKeys.onBoardingCategoryKey] ?: ""
                val result = mutableListOf<Int>()
                if (string.isNotEmpty()) {
                    string.forEach {
                        if (it!=',') result.add(it.toString().toInt())
                    }
                }
                result
            }
    }

    override suspend fun onBoardFinish(list: List<Int>) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.onBoardingKey] = true
        }
        val listAsString = list.joinToString(",")
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.onBoardingCategoryKey] = listAsString
        }
    }
    private fun dataProvide(): Flow<Preferences>{
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
    }
    override suspend fun getState(): Flow<Boolean> {
        return dataProvide().map { preferences ->
                val onBoardingState = preferences[PreferencesKeys.onBoardingKey] ?: false
                onBoardingState
            }
    }
}