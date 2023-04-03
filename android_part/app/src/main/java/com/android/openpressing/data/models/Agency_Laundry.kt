package com.android.openpressing.data.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class Agency_Laundry (
    var id: Int,
    val laundry: Laundry,
    var agency: Agency,
    @SerializedName("AddingDate") var addingDate: Date,
    @SerializedName("RetireDate") var retireDate: Date,
    var offers: MutableList<Offer>,
    var confirmed: Boolean,
    var blocked: Boolean
)
