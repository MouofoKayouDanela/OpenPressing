package com.android.openpressing.data.models.laundry_category

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LaundryCategoryData(
    var id: Int? = null ,
    var attributes: LaundryCategoryAttributes
):Parcelable
