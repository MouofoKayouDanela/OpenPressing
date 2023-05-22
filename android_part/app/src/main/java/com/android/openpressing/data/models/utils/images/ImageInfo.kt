package com.android.openpressing.data.models.utils.images

import java.util.*

data class ImageInfo(
    val id: Int,
    val name: String ,
    val alternativeText: String? ,
    val caption: String? ,
    val width: Int ,
    val height: Int ,
    val formats: Formats ,
    val hash: String ,
    val ext: String ,
    val mime: String ,
    val size: Double ,
    val url: String ,
    val previewUrl: String? ,
    val provider: String ,
    val provider_metadata: Any? ,
    val createdAt: Date ,
    val updatedAt: Date
)
