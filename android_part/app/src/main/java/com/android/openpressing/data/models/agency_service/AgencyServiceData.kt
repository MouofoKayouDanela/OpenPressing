package com.android.openpressing.data.models.agency_service

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class AgencyServiceData(
    var id: Int? = null,
    var attributes: AgencyServiceAttributes
):Parcelable
