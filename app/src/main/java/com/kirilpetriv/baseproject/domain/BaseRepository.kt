package com.kirilpetriv.baseproject.domain

interface BaseRepository {
    suspend fun getBaseModel(id: Int): BaseModel
}