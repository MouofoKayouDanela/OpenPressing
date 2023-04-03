package com.android.openpressing.data.models

import com.google.gson.annotations.SerializedName

data class Privelege (
    var id: Int,
    @SerializedName("Name") var name: String,
    @SerializedName("Description") var description: String,
    var agents: MutableList<Agent>,
    var confirmed: Boolean,
    var blocked: Boolean
)
