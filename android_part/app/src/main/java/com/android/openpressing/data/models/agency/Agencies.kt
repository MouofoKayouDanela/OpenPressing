package com.android.openpressing.data.models.agency

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Agencies(
    var data: MutableList<AgencyData>
):Parcelable
