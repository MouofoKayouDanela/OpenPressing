package com.android.openpressing.data.models.utils.images

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class ImageInfoData(
    val id: Int? = null,
    val attributes : ImageAttributes
):Parcelable
