package com.kirilpetriv.baseproject.uilayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kirilpetriv.baseproject.domain.BaseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BaseViewModel(private val baseRepository: BaseRepository) : ViewModel() {
    private val _state = MutableStateFlow<BaseScreenState>(BaseScreenState.Loading)
    val state: StateFlow<BaseScreenState> get() = _state

    fun fetchBaseModel(id: Int) {
        viewModelScope.launch {
            runCatching { baseRepository.getBaseModel(id) }
                .onSuccess { _state.value = BaseScreenState.Success(it) }
                .onFailure { _state.value = BaseScreenState.Error(it.message ?: "Unknown error") }
        }
    }
}