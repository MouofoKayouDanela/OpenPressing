package com.android.openpressing.data.models.agency_laundry

import android.os.Parcelable
import com.android.openpressing.data.models.laundry_category.laundry.Laundry
import com.android.openpressing.data.models.offer.Offer
import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.data.models.offer.Offers
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class AgencyLaundryAttributes (
    val laundry: Laundry ,
    var agency: Agency ,
    @SerializedName("AddingDate") var addingDate: Date = Date() ,
    @SerializedName("RetireDate") var retireDate: Date? = null ,
    var offers: Offers? = null ,
    var createdAt: Date = Date(),
    var updatedAt: Date = Date(),
    var publishedAt: Date = Date(),
    var confirmed: Boolean = true,
    var blocked: Boolean = false
):Parcelable