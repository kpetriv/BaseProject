package com.kirilpetriv.baseproject.network.networkerrors

class NoInternetConnection(
    message: String = "No internet connection available.",
    throwable: Throwable? = null
) : NetworkError(message = message, throwable = throwable)
