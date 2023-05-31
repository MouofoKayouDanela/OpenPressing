package com.android.openpressing.data.models.quarter

import android.os.Parcelable
import com.android.openpressing.data.models.city.City
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Quarter (
    var data: QuarterData
):Parcelable
