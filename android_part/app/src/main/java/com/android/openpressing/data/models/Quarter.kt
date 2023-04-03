package com.android.openpressing.data.models

import com.google.gson.annotations.SerializedName

data class Quarter (
    var id: Int,
    @SerializedName("Name") var name: String,
    val city: City,
    var agencies: MutableList<Agency>,
)
