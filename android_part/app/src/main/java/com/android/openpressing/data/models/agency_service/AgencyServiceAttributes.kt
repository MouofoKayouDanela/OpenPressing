package com.android.openpressing.data.models.agency_service

import com.android.openpressing.data.models.service.Service
import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.data.models.offer.Offers
import com.google.gson.annotations.SerializedName
import java.util.*

data class AgencyServiceAttributes(
    val agency: Agency ,
    var service: Service ,
    @SerializedName("AddingDate") var addingDate: Date ,
    @SerializedName("RetireDate") var retireDate: Date ,
    @SerializedName("Status") var status: String ,
    var offers: Offers ,
    var confirmed: Boolean ,
    var blocked: Boolean
)
