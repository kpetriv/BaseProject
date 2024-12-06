package com.kirilpetriv.baseproject.network.networkerrors

class NotFound(
    message: String = "HTTP Error 404.",
    throwable: Throwable? = null
) : NetworkError(message, throwable)
