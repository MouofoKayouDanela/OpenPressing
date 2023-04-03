package com.android.openpressing.data.models

import com.google.gson.annotations.SerializedName

data class Pressing(
    var id: Int ,
    @SerializedName("Name") var name: String ,
    val owner: Owner,
    var confirmed: Boolean,
    var blocked: Boolean
)
