package com.android.openpressing.data.models

import com.google.gson.annotations.SerializedName

data class Service_Type(
    var id: Int,
    @SerializedName("Title") var title: String,
    var services: MutableList<Service>,
    var confirmed: Boolean,
    var blocked: Boolean
)
