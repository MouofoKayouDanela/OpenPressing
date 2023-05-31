package com.android.openpressing.data.models.laundry_category.laundry

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class LaundryData(
    var id: Int? = null ,
    var attributes: LaundryAttributes
):Parcelable
