package com.android.openpressing.data.models

import com.google.gson.annotations.SerializedName


data class Annonce (
    var id: Int,
    @SerializedName("Description") var description: String,
    var offers: MutableList<Offer>,
    var confirmed: Boolean,
    var blocked: Boolean
)
