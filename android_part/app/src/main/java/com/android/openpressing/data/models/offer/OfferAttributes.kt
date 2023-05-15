package com.android.openpressing.data.models.offer

import com.android.openpressing.data.models.promotion.Promotion
import com.android.openpressing.data.models.agency_laundry.AgencyLaundry
import com.android.openpressing.data.models.agency_service.AgencyService
import com.android.openpressing.data.models.annonce.Announce
import com.google.gson.annotations.SerializedName

data class OfferAttributes(
    @SerializedName("UnitPrice") var unitPrice: Double ,
    var agency_laundry: AgencyLaundry ,
    var agency_service: AgencyService ,
    var announce: Announce ,
    var promotion: Promotion? = null ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
)
