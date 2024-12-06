package com.kirilpetriv.baseproject.network.core

import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory

private const val BASE_URL = "https://m.mobile.de"

class Client {

    val JsonConfig = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
        encodeDefaults = true
    }

    @Volatile
    private var retrofit: Retrofit? = null

    fun getInstance(okHttpClient: OkHttpClient): Retrofit = retrofit ?: synchronized(this) {
        retrofit ?: createInstance(okHttpClient).also { retrofit = it }
    }

    inline fun <reified SERVICE> createService(okHttpClient: OkHttpClient): SERVICE {
        return getInstance(okHttpClient).create(SERVICE::class.java)
    }

    private fun createInstance(okHttpClient: OkHttpClient): Retrofit {
        val jsonContentType: MediaType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(NetworkCallAdapter())
            .addConverterFactory(JsonConfig.asConverterFactory(contentType = jsonContentType))
            .client(okHttpClient)
            .build()
    }
}