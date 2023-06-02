package com.android.openpressing.data.models.agency_service

import com.google.gson.annotations.SerializedName
import java.util.*

data class AgencyServiceInfoData(
    var id: Int? = null ,
    var service: Int ,
    val agency: Int ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false ,
)
