package com.android.openpressing.data.models.utils.images

import java.util.*

data class ImageInfo(
    val id: Int? = null,
    val name: String ,
    val alternativeText: String? = null ,
    val caption: String? = null ,
    val width: Int ,
    val height: Int ,
    val formats: Formats? = null ,
    val hash: String? = null ,
    val ext: String? = null,
    val mime: String? = null ,
    val size: Double ,
    val url: String? = null ,
    val previewUrl: String? = null  ,
    val provider: String? = null ,
    val provider_metadata: Any? = null  ,
    val createdAt: Date = Date() ,
    val updatedAt: Date = Date()
)
