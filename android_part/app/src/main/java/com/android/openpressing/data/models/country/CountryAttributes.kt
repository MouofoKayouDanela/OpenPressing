package com.android.openpressing.data.models.country

import com.android.openpressing.data.models.city.Cities
import com.google.gson.annotations.SerializedName

data class CountryAttributes(
    @SerializedName("Name") var name: String ,
    var cities: Cities? = null ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
)
