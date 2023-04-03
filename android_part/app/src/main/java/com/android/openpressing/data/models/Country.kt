package com.android.openpressing.data.models

import com.google.gson.annotations.SerializedName

data class Country(
    var id: Int,
    @SerializedName("Name") var name: String,
    var cities: MutableList<City>,
    var confirmed: Boolean,
    var blocked: Boolean
)
