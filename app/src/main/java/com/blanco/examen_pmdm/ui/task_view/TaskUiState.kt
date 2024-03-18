package com.blanco.examen_pmdm.ui.task_view

import com.blanco.examen_pmdm.data.network.model.TaskResponse

data class TaskUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val response: List<TaskResponse>? = null
)
