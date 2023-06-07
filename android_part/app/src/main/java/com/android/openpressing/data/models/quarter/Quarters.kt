package com.android.openpressing.data.models.quarter

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Quarters(
    var data: MutableList<QuarterData>
):Parcelable
