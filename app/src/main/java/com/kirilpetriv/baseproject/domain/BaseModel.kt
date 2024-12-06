package com.kirilpetriv.baseproject.domain

data class BaseModel(
    val imageStrings: List<BaseImageString>
) {
    @JvmInline
    value class BaseImageString(val value: String)
}