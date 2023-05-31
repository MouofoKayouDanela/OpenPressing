package com.android.openpressing.data.models.utils.images

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Formats(
    val thumbnail: Thumbnail,
    val medium: Medium,
    val small: Small,
    val large: Large
):Parcelable