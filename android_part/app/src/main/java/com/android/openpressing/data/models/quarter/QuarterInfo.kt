package com.android.openpressing.data.models.quarter

import com.google.gson.annotations.SerializedName

data class QuarterInfo(
    var id: Int? = null,
    @SerializedName("Name") var name: String,
)
