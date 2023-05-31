package com.android.openpressing.data.models.country

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class CountryData(
    var id: Int? = null ,
    var attributes: CountryAttributes
):Parcelable
