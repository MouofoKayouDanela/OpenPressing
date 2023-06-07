package com.android.openpressing.data.models.pressing

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PressingData(
    var id: Int? = null ,
    var attributes: PressingAttributes
):Parcelable
