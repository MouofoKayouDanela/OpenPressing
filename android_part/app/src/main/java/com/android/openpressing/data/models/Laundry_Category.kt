package com.android.openpressing.data.models

import com.google.gson.annotations.SerializedName

data class Laundry_Category(
    var id: Int,
    @SerializedName("Name") var name: String,
    var laundries: MutableList<Laundry>,
    var confirmed: Boolean,
    var blocked: Boolean
)
