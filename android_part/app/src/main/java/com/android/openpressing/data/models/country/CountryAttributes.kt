package com.android.openpressing.data.models.country

import android.os.Parcelable
import com.android.openpressing.data.models.city.Cities
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*
@Parcelize
data class CountryAttributes(
    @SerializedName("Name") var name: String ,
    var cities: Cities? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
):Parcelable
