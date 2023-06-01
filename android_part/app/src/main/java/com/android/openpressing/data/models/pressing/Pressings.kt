package com.android.openpressing.data.models.pressing

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pressings(
    var data: MutableList<PressingData>
):Parcelable
