package com.android.openpressing.data.models.city

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CityData(
    var id: Int? = null ,
    var attributes: CityAttributes
):Parcelable
