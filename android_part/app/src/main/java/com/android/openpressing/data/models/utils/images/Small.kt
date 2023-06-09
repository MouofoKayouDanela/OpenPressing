package com.android.openpressing.data.models.utils.images

data class Small(
    val name: String,
    val hash: String,
    val ext: String,
    val mime: String,
    val path: Any?, // ou la structure appropriée si elle est définie
    val width: Int,
    val height: Int,
    val size: Double,
    val url: String
)
