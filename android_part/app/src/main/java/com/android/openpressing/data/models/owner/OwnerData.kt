package com.android.openpressing.data.models.owner

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class OwnerData(
    var id: Int? = null ,
    var attributes: OwnerAttributes
):Parcelable
