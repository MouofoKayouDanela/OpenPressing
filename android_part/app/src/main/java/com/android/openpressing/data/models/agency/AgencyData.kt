package com.android.openpressing.data.models.agency

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AgencyData(
    var id: Int? = null ,
    var attributes: AgencyAttributes
):Parcelable
