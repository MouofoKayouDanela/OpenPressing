package com.android.openpressing.data.models.offer

import android.os.Parcelable
import com.android.openpressing.data.models.promotion.Promotion
import com.android.openpressing.data.models.agency_laundry.AgencyLaundry
import com.android.openpressing.data.models.agency_service.AgencyService
import com.android.openpressing.data.models.annonce.Announce
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*
@Parcelize
data class OfferAttributes(
    @SerializedName("UnitPrice") var unitPrice: Double ,
    var agency_laundry: AgencyLaundry ,
    var agency_service: AgencyService ,
    var announce: Announce ,
    var promotion: Promotion? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
):Parcelable
