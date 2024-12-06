package com.kirilpetriv.baseproject.network.networkerrors

class Unauthorised(
    message: String = "HTTP Error 401. Client is not authorized.",
    throwable: Throwable? = null
) : NetworkError(message, throwable)
