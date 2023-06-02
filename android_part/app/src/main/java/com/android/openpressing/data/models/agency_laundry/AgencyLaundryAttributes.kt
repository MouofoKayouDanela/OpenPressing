package com.android.openpressing.data.models.agency_laundry

import com.android.openpressing.data.models.laundry.Laundry
import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.data.models.offer.Offers
import com.google.gson.annotations.SerializedName
import java.util.*

data class AgencyLaundryAttributes (
    val laundry: Laundry ,
    var agency: Agency ,
    @SerializedName("AddingDate") var addingDate: Date = Date() ,
    @SerializedName("RetireDate") var retireDate: Date? = null ,
    var offers: Offers? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
)