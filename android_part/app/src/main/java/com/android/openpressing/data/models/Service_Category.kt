package com.android.openpressing.data.models

import com.google.gson.annotations.SerializedName

data class Service_Category (
    var id: Int,
    @SerializedName("Name") var name: String,
    var services: MutableList<Service>,
    var confirmed: Boolean,
    var blocked: Boolean
)