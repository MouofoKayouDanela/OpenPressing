package com.android.openpressing.data.models.agency_service

import com.android.openpressing.data.models.service.Service
import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.data.models.offer.Offers
import com.google.gson.annotations.SerializedName
import java.util.*

data class AgencyServiceAttributes(
    val agency: Agency ,
    var service: Service ,
    @SerializedName("AddingDate") var addingDate: Date = Date() ,
    @SerializedName("RetireDate") var retireDate: Date? = null ,
    @SerializedName("Status") var status: String ,
    var offers: Offers? = null ,
    var createdAt: Date = Date(),
    var updatedAt: Date = Date(),
    var publishedAt: Date = Date(),
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
)
