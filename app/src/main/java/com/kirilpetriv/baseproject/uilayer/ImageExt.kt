package com.kirilpetriv.baseproject.uilayer

import com.kirilpetriv.baseproject.domain.BaseModel

fun BaseModel.BaseImageString.toThumbnailUrl(): String {
    val url =  buildString {
        append("https://")
        append(this@toThumbnailUrl.value)
        append("?rule=mo-640.jpg")
    }
    return url
}