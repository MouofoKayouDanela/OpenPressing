package com.android.openpressing.data.models.laundry_type

import android.os.Parcelable
import com.android.openpressing.data.models.laundry_category.laundry.Laundry
import kotlinx.parcelize.Parcelize

@Parcelize
data class LaundryType(
    var data: LaundryTypeData
):Parcelable
