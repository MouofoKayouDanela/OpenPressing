package com.android.openpressing.data.models.requirement_detail

import com.android.openpressing.data.models.service.Service
import com.android.openpressing.data.models.laundry_category.laundry.Laundry
import com.android.openpressing.data.models.requirement.Requirement
import com.google.gson.annotations.SerializedName
import java.util.*

data class RequirementDetailAttributes(
    var laundry: Laundry ,
    var service: Service ,
    @SerializedName("Quantity") var quantity : Int ,
    @SerializedName("UnitPrice") var unitPrice: Double ,
    @SerializedName("Name") var name: String ,
    @SerializedName("Description") var description: String ,
    val requirement: Requirement ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
)
