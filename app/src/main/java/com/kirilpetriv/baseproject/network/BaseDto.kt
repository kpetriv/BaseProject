package com.kirilpetriv.baseproject.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseDto(
    @SerialName("images")
    val images: List<UriHolder>
) {
    @Serializable
    data class UriHolder(
        @SerialName("uri")
        val uri: String
    )
}