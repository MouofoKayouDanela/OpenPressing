package com.android.openpressing.data.models

import com.google.gson.annotations.SerializedName

data class Requirement_Detail (
    var id: Int,
    var laundry: Laundry,
    var service: Service,
    @SerializedName("Quantity") var quantity : Int,
    @SerializedName("UnitPrice") var unitPrice: Double,
    @SerializedName("Name") var name: String,
    @SerializedName("Description") var description: String,
    val requirement: Requirement,
    var confirmed: Boolean,
    var blocked: Boolean
)