package com.android.openpressing.data.models

import com.google.gson.annotations.SerializedName

data class Offer (
    var id: Int ,
    @SerializedName("UnitPrice") var unitPrice: Double ,
    var agency_laundry: Agency_Laundry ,
    var agency_service: Agency_Service ,
    var announce: Annonce ,
    var promotion: Promotion ,
    var confirmed: Boolean ,
    var blocked: Boolean

)
