package com.blanco.examen_pmdm.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object DataStoreManager {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "MY_DATA_STORE")

    private val departmentkey = stringPreferencesKey("DEPARTMENT_KEY")

    suspend fun saveDepartment(context: Context, sampleData: String) {
        context.dataStore.edit { editor ->
            editor[departmentkey] = sampleData
        }
    }

    suspend fun getDepartment(context: Context): Flow<String> {
        return context.dataStore.data.map { editor ->
            editor[departmentkey] ?: "No hay datos"
        }
    }

//    suspend fun deleteAll(context: Context) {
//        context.dataStore.edit { editor ->
//            editor.clear()//borrar todos
//        }
//    }
//
//    suspend fun deleteSample(context: Context) {
//        context.dataStore.edit { editor ->
//            editor.remove(departmentkey)//borrar solo un dato
//        }
//    }
}