package com.android.openpressing.data.models.city

import android.os.Parcelable
import com.android.openpressing.data.models.country.Country
import com.android.openpressing.data.models.quarter.Quarter
import com.android.openpressing.data.models.quarter.Quarters
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class CityAttributes(
    @SerializedName("Name") var name: String ,
    val country: Country ,
    var quarters: Quarters? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
):Parcelable
