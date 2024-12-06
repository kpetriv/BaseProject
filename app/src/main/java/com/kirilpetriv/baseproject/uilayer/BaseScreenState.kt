package com.kirilpetriv.baseproject.uilayer

import com.kirilpetriv.baseproject.domain.BaseModel

sealed class BaseScreenState {
    data object Loading : BaseScreenState()
    data class Success(val data: BaseModel) : BaseScreenState()
    data class Error(val message: String) : BaseScreenState()
}