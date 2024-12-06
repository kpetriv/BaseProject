package com.kirilpetriv.baseproject.network.core

import com.kirilpetriv.baseproject.network.networkerrors.Forbidden
import com.kirilpetriv.baseproject.network.networkerrors.NetworkError
import com.kirilpetriv.baseproject.network.networkerrors.NotFound
import com.kirilpetriv.baseproject.network.networkerrors.Unauthorised
import retrofit2.Response

fun <T> Response<T>.toNetworkResult(): NetworkResult<T> = runCatching { requireNotNull(body()) }
    .map { NetworkResult.Success(it) }
    .recoverCatching { NetworkResult.Failure(toNetworkError()) }
    .getOrElse { NetworkResult.Failure(NetworkError(throwable = it)) }

private fun <T> Response<T>.toNetworkError(): NetworkError {
    return when (code()) {
        401 -> Unauthorised()
        403 -> Forbidden()
        404 -> NotFound()
        else -> NetworkError(message = "${code()}: ${errorBody()?.string()} ")
    }
}
