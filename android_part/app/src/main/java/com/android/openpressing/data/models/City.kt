package com.android.openpressing.data.models

import com.google.gson.annotations.SerializedName

data class City (
    var id: Int ,
    @SerializedName("Name") var name: String ,
    val country: Country ,
    var quarters: MutableList<Quarter> ,
    var confirmed: Boolean ,
    var blocked: Boolean
)