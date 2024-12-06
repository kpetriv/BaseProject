package com.kirilpetriv.baseproject.network.core

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class NetworkAdapter(private val type: Type) : CallAdapter<Type, Call<NetworkResult<Type>>> {
    override fun responseType() = type
    override fun adapt(call: Call<Type>): Call<NetworkResult<Type>> = NetworkCall(call)
}
