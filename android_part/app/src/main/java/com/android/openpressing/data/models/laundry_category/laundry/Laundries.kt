package com.android.openpressing.data.models.laundry_category.laundry

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Laundries(
    var data: MutableList<LaundryData>
):Parcelable
