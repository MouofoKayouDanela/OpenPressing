package com.android.openpressing.data.models.laundry_category

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LaundryCategory(
    var data: LaundryCategoryData
): Parcelable
