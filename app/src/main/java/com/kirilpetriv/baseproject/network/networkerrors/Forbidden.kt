package com.kirilpetriv.baseproject.network.networkerrors

class Forbidden(
    message: String = "Forbidden request",
    throwable: Throwable? = null
) : NetworkError(message = message, throwable = throwable)
