package com.android.openpressing.data.models.city

import com.android.openpressing.data.models.country.Country
import com.android.openpressing.data.models.quarter.Quarter
import com.android.openpressing.data.models.quarter.Quarters
import com.google.gson.annotations.SerializedName

data class CityAttributes(
    @SerializedName("Name") var name: String ,
    val country: Country ,
    var quarters: Quarters? = null ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
)
