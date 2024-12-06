package com.kirilpetriv.baseproject.network.core

import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class NetworkCallDelegate<IN, OUT>(protected val proxy: Call<IN>) : Call<OUT> {

    override fun execute(): Response<OUT> = throw NotImplementedError()
    final override fun enqueue(callback: Callback<OUT>) = enqueueImpl(callback)
    final override fun clone(): Call<OUT> = cloneImpl()

    override fun cancel() = proxy.cancel()
    override fun request(): Request = proxy.request()
    override fun isExecuted() = proxy.isExecuted
    override fun isCanceled() = proxy.isCanceled
    override fun timeout() = proxy.timeout()

    abstract fun enqueueImpl(callback: Callback<OUT>)
    abstract fun cloneImpl(): Call<OUT>
}
