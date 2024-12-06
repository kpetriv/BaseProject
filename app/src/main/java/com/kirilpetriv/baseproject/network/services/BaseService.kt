package com.kirilpetriv.baseproject.network.services

import com.kirilpetriv.baseproject.network.BaseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BaseService {
    @GET("/svc/a/{id}")
    suspend fun getBaseDto(
        @Path("id") id: Int,
    ): Response<BaseDto>
}