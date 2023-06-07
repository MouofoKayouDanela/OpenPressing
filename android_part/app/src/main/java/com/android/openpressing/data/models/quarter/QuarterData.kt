package com.android.openpressing.data.models.quarter

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuarterData(
    var id: Int? = null ,
    var attributes: QuarterAttributes
):Parcelable
