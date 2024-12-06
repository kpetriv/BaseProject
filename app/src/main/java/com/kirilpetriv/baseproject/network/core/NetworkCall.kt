package com.kirilpetriv.baseproject.network.core

import com.kirilpetriv.baseproject.network.networkerrors.NetworkError
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkCall<T>(proxy: Call<T>) : NetworkCallDelegate<T, NetworkResult<T>>(proxy) {

    override fun enqueueImpl(callback: Callback<NetworkResult<T>>) = proxy.enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            callback.onResponse(this@NetworkCall, Response.success(response.toNetworkResult()))
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            val networkError = if (t is NetworkError) t else NetworkError(throwable = t)
            val result: NetworkResult<T> = NetworkResult.Failure(networkError = networkError)
            callback.onResponse(this@NetworkCall, Response.success(result))
        }
    })

    override fun cloneImpl() = NetworkCall(proxy.clone())
}
