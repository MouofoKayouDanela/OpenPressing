package com.android.openpressing.data.models.agency_laundry

import com.google.gson.annotations.SerializedName
import java.util.*

data class AgencyLaundryInfoData(
    var id: Int? = null ,
    val laundry: Int ,
    var agency: Int ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false,
)
