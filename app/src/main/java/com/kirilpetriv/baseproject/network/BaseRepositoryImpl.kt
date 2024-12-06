package com.kirilpetriv.baseproject.network

import com.kirilpetriv.baseproject.domain.BaseModel
import com.kirilpetriv.baseproject.domain.BaseRepository
import com.kirilpetriv.baseproject.network.core.NetworkResult
import com.kirilpetriv.baseproject.network.core.toNetworkResult
import com.kirilpetriv.baseproject.network.services.BaseService

class BaseRepositoryImpl(
    private val baseService: BaseService,
) : BaseRepository {
    override suspend fun getBaseModel(id: Int): BaseModel {
        return when (val result = baseService.getBaseDto(id = id).toNetworkResult()) {
            is NetworkResult.Success -> result.value.toDomain()
            is NetworkResult.Failure -> throw result.networkError
        }
    }
}