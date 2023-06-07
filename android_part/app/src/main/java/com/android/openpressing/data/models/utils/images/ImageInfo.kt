package com.android.openpressing.data.models.utils.images

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*
@Parcelize
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
    val size: Double? = null ,
    val url: String? = null ,
    val previewUrl: String? = null  ,
    val provider: String? = null ,
    val createdAt: Date = Date() ,
    val updatedAt: Date = Date()
):Parcelable
