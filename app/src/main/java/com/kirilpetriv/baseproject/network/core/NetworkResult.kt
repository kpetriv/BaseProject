package com.kirilpetriv.baseproject.network.core

import com.kirilpetriv.baseproject.network.networkerrors.NetworkError

sealed class NetworkResult<out T> {
    class Success<T>(val value: T) : NetworkResult<T>()
    class Failure(val networkError: NetworkError) : NetworkResult<Nothing>()
}
