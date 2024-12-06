package com.kirilpetriv.baseproject.network

import com.kirilpetriv.baseproject.domain.BaseModel
import com.kirilpetriv.baseproject.domain.BaseModel as CarImagesModel
import com.kirilpetriv.baseproject.network.BaseDto as CarImagesDto


internal fun CarImagesDto.toDomain(): CarImagesModel {
    return CarImagesModel(
        imageStrings = images.map { BaseModel.BaseImageString(it.uri) }
    )
}