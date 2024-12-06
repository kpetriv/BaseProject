package com.kirilpetriv.baseproject.network.core

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class HttpClientFactory {

    fun getHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("User-Agent", "PostmanRuntime/7.37.3")
                    .addHeader("X-Mobile-Api-Version", "10")
                    .build()
                chain.proceed(request)
            }

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return builder.addInterceptor(logging).build()
    }
}