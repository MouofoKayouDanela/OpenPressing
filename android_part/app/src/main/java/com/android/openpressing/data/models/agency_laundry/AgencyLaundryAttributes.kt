package com.android.openpressing.data.models.agency_laundry

import com.android.openpressing.data.models.laundry.Laundry
import com.android.openpressing.data.models.offer.Offer
import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.data.models.offer.Offers
import com.google.gson.annotations.SerializedName
import java.util.*

data class AgencyLaundryAttributes (
    val laundry: Laundry ,
    var agency: Agency ,
    @SerializedName("AddingDate") var addingDate: Date ,
    @SerializedName("RetireDate") var retireDate: Date ,
    var offers: Offers? = null ,
    var confirmed: Boolean = true,
    var blocked: Boolean = false
)