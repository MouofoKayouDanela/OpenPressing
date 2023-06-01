package com.android.openpressing.data.models.city

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class City (
    var data: CityData
):Parcelable