package com.android.openpressing.data.models.country

import android.os.Parcelable
import com.android.openpressing.data.models.city.City
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
   var data: CountryData
):Parcelable
