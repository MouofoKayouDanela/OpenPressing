package com.android.openpressing.data.models.agency_service

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AgencyServices(
    var data: MutableList<AgencyServiceData>
):Parcelable
