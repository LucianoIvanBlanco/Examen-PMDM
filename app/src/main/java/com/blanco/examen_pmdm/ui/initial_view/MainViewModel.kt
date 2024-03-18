package com.blanco.examen_pmdm.ui.initial_view

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blanco.examen_pmdm.data.storage.DataStoreManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    fun saveDepartment(context: Context, department: String){
        viewModelScope.launch(Dispatchers.IO){
            DataStoreManager.saveDepartment(context, department)
        }
    }

}