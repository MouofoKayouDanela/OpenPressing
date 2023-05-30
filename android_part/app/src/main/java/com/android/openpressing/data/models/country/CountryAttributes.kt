package com.android.openpressing.data.models.country

import com.android.openpressing.data.models.city.Cities
import com.google.gson.annotations.SerializedName
import java.util.*

data class CountryAttributes(
    @SerializedName("Name") var name: String ,
    var cities: Cities? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
)
