package com.android.openpressing.data.models.agency_laundry

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class AgencyLaundryData(
    var id: Int? = null ,
    var attributes: AgencyLaundryAttributes
):Parcelable
