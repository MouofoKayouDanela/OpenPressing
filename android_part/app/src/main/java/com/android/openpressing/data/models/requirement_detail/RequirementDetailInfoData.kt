package com.android.openpressing.data.models.requirement_detail

import com.google.gson.annotations.SerializedName

data class RequirementDetailInfoData(
    var id: Int? = null ,
    var laundry : Int,
    var service : Int,
    @SerializedName("Quantity") var quantity : Int ,
    @SerializedName("UnitPrice") var unitPrice: Double ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
)
