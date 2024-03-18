package com.blanco.examen_pmdm.data.network

import com.blanco.examen_pmdm.data.network.model.TaskResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface DepartmentService {
    @GET("task/{department}")
    suspend fun getTasks(
        @Header("Authorization") authToken: String,
        @Path("department") department: String
    ): Response<List<TaskResponse>>
}
