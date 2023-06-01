package com.android.openpressing.data.models.laundry_type

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class LaundryTypeData(
    var id: Int? = null ,
    var attributes: LaundryTypeAttributes
):Parcelable
