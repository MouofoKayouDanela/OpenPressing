package com.android.openpressing.data.models.utils.images

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Medium(
    val name: String,
    val hash: String,
    val ext: String,
    val mime: String,
    val width: Int,
    val height: Int,
    val size: Double,
    val url: String
):Parcelable
