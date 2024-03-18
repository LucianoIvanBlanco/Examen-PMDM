package com.blanco.examen_pmdm.ui.task_view

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blanco.examen_pmdm.data.network.DepartmentApi
import com.blanco.examen_pmdm.data.storage.DataStoreManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {

    private var _department: MutableLiveData<String?> = MutableLiveData(null)
    val department: LiveData<String?> = _department

    private var _uiState: MutableLiveData<TaskUiState> = MutableLiveData(TaskUiState())
    val uiState: LiveData<TaskUiState> get() = _uiState


    fun getDepartment(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            DataStoreManager.getDepartment(context).collect { department ->
                if (department != "No hay datos") {
                    _department.postValue(department)
                }
            }
        }
    }

    fun getTask(department: String) {
        _uiState.postValue(TaskUiState(isLoading = true))

        viewModelScope.launch(Dispatchers.IO) {
            val response = DepartmentApi.service.getTasks(department, "Luciano")
            if (response.isSuccessful) {
                _uiState.postValue(TaskUiState(response = response.body()))
            } else {
                _uiState.postValue(TaskUiState(isError = true))
            }
        }
    }


}