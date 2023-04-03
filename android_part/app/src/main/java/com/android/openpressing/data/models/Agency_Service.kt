package com.android.openpressing.data.models

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Agency_Service (
    var id: Int,
    val agency: Agency,
    var service: Service,
    @SerializedName("AddingDate") var addingDate: Date,
    @SerializedName("RetireDate") var retireDate: Date,
    @SerializedName("Status") var status: String,
    var offers: MutableList<Offer>,
    var confirmed: Boolean,
    var blocked: Boolean
)
