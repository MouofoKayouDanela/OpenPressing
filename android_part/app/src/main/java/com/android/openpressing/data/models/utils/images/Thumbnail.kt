package com.android.openpressing.data.models.utils.images

data class Thumbnail(
    val name: String,
    val hash: String,
    val ext: String,
    val mime: String,
    val path: Any?,
    val width: Int,
    val height: Int,
    val size: Double,
    val url: String
)
