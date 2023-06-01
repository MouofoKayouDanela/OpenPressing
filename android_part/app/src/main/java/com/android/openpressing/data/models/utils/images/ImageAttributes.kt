package com.android.openpressing.data.models.utils.images

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class ImageAttributes(
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
    val createdAt: Date ,
    val updatedAt: Date
):Parcelable
