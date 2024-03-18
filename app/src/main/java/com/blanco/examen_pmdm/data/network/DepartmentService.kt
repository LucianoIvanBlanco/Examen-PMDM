package com.blanco.examen_pmdm.data.network

import com.blanco.examen_pmdm.data.network.model.TaskResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface DepartmentService {
    @GET("task/{department}") // IMPORTANTE no poner \ al principip
    suspend fun getHomeWork(
        @Header("Luciano Blanco") userName: String, // Aqui los datos que tengamos que enviar
        @Path("department") department: String   // el path que le pasamos a la URL
    ): Response<List<TaskResponse>> // Objeto que nos devuelve
}